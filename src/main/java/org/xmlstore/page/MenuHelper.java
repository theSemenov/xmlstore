package org.xmlstore.page;

public class MenuHelper {
	private String menuItemId;
	private static final String SELECTED_STYLE = "pure-menu-selected";
	private static final String NONE_SELECTED_STYLE = "";

	public MenuHelper(){

	} 
	
	public MenuHelper(String menuItemId){
		this.menuItemId = menuItemId;
	}
	
	public String getStyle(String locationId){
		if(locationId.equalsIgnoreCase(menuItemId)) {
			return SELECTED_STYLE;
		} else {
			return NONE_SELECTED_STYLE;
		}
	}

	public String getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(String menuItemId) {
		this.menuItemId = menuItemId;
	};
}
