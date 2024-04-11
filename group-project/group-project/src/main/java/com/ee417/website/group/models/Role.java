package com.ee417.website.group.models;

/**
 * @author Peter Staunton
 * @date 06/04/2024
 * @category model
 * Provides object to interact with clients
 */
// Using example from lectures
public class Role {
    private RoleName name;
    
    public Role() {}
    
    public Role(RoleName name) {
    	this.setName(name);
    }

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}
}
