/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package org.vaadin.smartgwt.server.types;

public enum BkgndRepeat implements ValueEnum
{
	/**
	 * Tile the background image horizontally and vertically.
	 */
	REPEAT("repeat"),

	/**
	 * Don't tile the background image at all.
	 */
	NO_REPEAT("no-repeat"),

	/**
	 * Repeat the background image horizontally but not vertically.
	 */
	REPEAT_X("repeat-x"),

	/**
	 * Repeat the background image vertically but not horizontally.
	 */
	REPEAT_Y("repeat-y");

	private String value;

	BkgndRepeat(String value)
	{
		this.value = value;
	}

	@Override
	public String getValue()
	{
		return this.value;
	}
}
