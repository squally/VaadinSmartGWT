package org.vaadin.smartgwt.client.util;

import org.vaadin.rpc.client.ClientSideHandler;
import org.vaadin.rpc.client.ClientSideProxy;
import org.vaadin.rpc.shared.Method;
import org.vaadin.smartgwt.client.ui.layout.VMasterContainer;

import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

public class VSC extends Canvas implements Paintable, ClientSideHandler
{
	protected String paintableId;
	private ApplicationConnection client;
	private final ClientSideProxy rpc = new ClientSideProxy("VSC", this);

	public VSC()
	{
		super();

		rpc.register("sayNoCallback", new Method()
			{
				public void invoke(final String methodName, final Object[] data)
				{
					if (data.length == 1)
					{
						SC.say((String) data[0]);
					}
					else
					{
						SC.say((String) data[0], (String) data[1]);
					}
				}
			});

		rpc.register("sayWithCallback", new Method()
			{
				public void invoke(final String methodName, final Object[] data)
				{
					if (data.length == 1)
					{
						// simple message
						SC.say((String) data[0], new BooleanCallback()
							{
								@Override
								public void execute(Boolean value)
								{
									client.updateVariable(paintableId, "callback", value != null ? value : false, true);
								}
							});
					}
					else
					{
						SC.say((String) data[0], (String) data[1], new BooleanCallback()
							{
								@Override
								public void execute(Boolean value)
								{
									client.updateVariable(paintableId, "callback", value != null ? value : false, true);
								}
							});
					}
				}
			});
	}


	@Override
	public Element getElement()
	{
		return VMasterContainer.getDummy();
	}

	@Override
	public void updateFromUIDL(UIDL uidl, ApplicationConnection client)
	{
		rpc.update(this, uidl, client);

		this.client = client;
		paintableId = uidl.getId();
	}

	@Override
	public boolean initWidget(Object[] params)
	{
		rpc.clientInitComplete();
		return true;
	}

	@Override
	public void handleCallFromServer(String method, Object[] params)
	{
		System.out.println("method call: " + method);
	}

}