package org.vaadin.smartgwt.server.form.fields;

import java.util.Map;


import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;

/**
 * Server side component for the VTextItem widget.
 */
@com.vaadin.ui.ClientWidget(org.vaadin.smartgwt.client.ui.form.fields.VTextItem.class)
public class TextItem extends FormItem
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextItem()
	{
		super("");
	}

	public TextItem(String name)
	{
		super(name);
	}

	/**
	 * Receive and handle events and other variable changes from the client.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void changeVariables(final Object source, final Map<String, Object> variables)
	{
		super.changeVariables(source, variables);

		if (variables.containsKey("value"))
		{
			setAttribute("value", variables.get("value"));

			ChangedEvent event = new ChangedEvent(null)
				{
					@Override
					public Object getValue()
					{
						return variables.get("value");
					}
				};

			fireChangedHandler(event);
		}
	}

}
