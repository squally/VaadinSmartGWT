package org.vaadin.smartgwt.server.layout;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.vaadin.smartgwt.server.Canvas;
import org.vaadin.smartgwt.server.Label;

import com.vaadin.ui.Component;

public class BorderLayout extends VLayout
{
	private final HLayout centerLayout = new HLayout();
	private Canvas center = new NullMember();
	private Canvas north = new NullMember();
	private Canvas south = new NullMember();
	private Canvas west = new NullMember();
	private Canvas east = new NullMember();

	public BorderLayout()
	{
		centerLayout.setHeight("*");
		centerLayout.addMember(west);
		centerLayout.addMember(center);
		centerLayout.addMember(east);
		super.addMember(north);
		super.addMember(centerLayout);
		super.addMember(south);
	}

	public Canvas getCenterMember()
	{
		return center instanceof NullMember ? null : center;
	}

	public void setCenterMember(Canvas member)
	{
		centerLayout.replaceMember(this.center, this.center = configureCenterMember(member));
	}

	public Canvas getNorthMember()
	{
		return north instanceof NullMember ? null : north;
	}

	public void setNorthMember(Canvas member)
	{
		super.replaceMember(this.north, this.north = configureVerticalMember(member));
	}

	public Canvas getSouthMember()
	{
		return south instanceof NullMember ? null : south;
	}

	public void setSouthMember(Canvas member)
	{
		super.replaceMember(this.south, this.south = configureVerticalMember(member));
	}

	public Canvas getWestMember()
	{
		return west instanceof NullMember ? null : west;
	}

	public void setWestMember(Canvas member)
	{
		centerLayout.replaceMember(this.west, this.west = configureHorizontalMember(member));
	}

	public Canvas getEastMember()
	{
		return east instanceof NullMember ? null : east;
	}

	public void setEastMember(Canvas member)
	{
		centerLayout.replaceMember(this.east, this.east = configureHorizontalMember(member));
	}

	@Override
	public Boolean hasMember(Canvas member)
	{
		return super.hasMember(member) || centerLayout.hasMember(member);
	}

	@Override
	public Canvas[] getMembers()
	{
		return newMembersSet().toArray(new Canvas[0]);
	}

	@Override
	public Iterator<Component> getComponentIterator()
	{
		return newMembersSet().iterator();
	}

	@Override
	public void addMember(Canvas component)
	{
		throw newUnsupportedOperationException();
	}

	@Override
	public void addMember(Canvas component, int position)
	{
		throw newUnsupportedOperationException();
	}

	@Override
	public void removeMember(Canvas member)
	{
		throw newUnsupportedOperationException();
	}

	@Override
	public void setMembers(Canvas... newMembers)
	{
		throw newUnsupportedOperationException();
	}

	@Override
	public void setMembers(List<Canvas> members)
	{
		throw newUnsupportedOperationException();
	}

	@Override
	public void removeMemberAt(int pos)
	{
		throw newUnsupportedOperationException();
	}

	@Override
	public void replaceMember(Canvas oldComponent, Canvas newComponent)
	{
		throw newUnsupportedOperationException();
	}

	private Canvas configureCenterMember(Canvas member)
	{
		if (member == null)
		{
			return new NullMember();
		}
		else
		{
			member.setHeight("100%");
			member.setWidth("100%");
			return member;
		}
	}

	private Canvas configureVerticalMember(Canvas member)
	{
		if (member == null)
		{
			return new NullMember();
		}
		else
		{
			if (member.getHeightAsString() == null)
			{
				member.setAutoHeight();
			}

			member.setWidth("100%");
			return member;
		}
	}

	private Canvas configureHorizontalMember(Canvas member)
	{
		if (member == null)
		{
			return new NullMember();
		}
		else
		{
			if (member.getWidthAsString() == null)
			{
				member.setAutoWidth();
			}

			member.setHeight("100%");
			return member;
		}
	}

	private Set<Component> newMembersSet()
	{
		final Set<Component> members = new HashSet<Component>();
		members.add(getNorthMember());
		members.add(getSouthMember());
		members.add(getWestMember());
		members.add(getEastMember());
		members.add(getCenterMember());
		members.remove(null);
		return members;
	}

	private UnsupportedOperationException newUnsupportedOperationException()
	{
		return new UnsupportedOperationException("Member operation not supported in BorderLayout.  Use constrainted member getters and setters instead.");
	}

	private static class NullMember extends Label
	{
		public NullMember()
		{
			super("");
			setVisible(false);
		}
	}
}