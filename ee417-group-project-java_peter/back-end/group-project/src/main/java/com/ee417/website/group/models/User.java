package com.ee417.website.group.models;

public class User {
	private long id; // user id
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String password; // pw hashed
//	private Collection<Role> roles; // user roles, admin etc.
	private Role role; // swapping to single Role per user
	
	// Noarg constructor
	public User() {}
	
	// Default constructor
//	public User(Long id, String firstName, String lastName, String email, String address, String password, Collection<Role> roles) {
	public User(Long id, String username, String firstName, String lastName, String email, String address, String password, Role role) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.password = password;
		this.role = role;
	}
	
	public static UserBuilder builder() {
		return new UserBuilder();
	}
	
	public Long getId() {
		return this.id;
	}
    
    public void setID(Long id) {
    	this.id = id;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Combine address and eircode
    public String getAddress() {
    	return this.address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    	
//    public Collection<Role> getRoles() {
//    	return this.roles;
//    }
//    
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }
    
    public Role getRole() {
    	return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    // Builder pattern
    public static class UserBuilder {
        private Long id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String password;
//        private Collection<Role> roles;
        private Role role;

        UserBuilder() {}

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }
        
        public UserBuilder username(String username) {
        	this.username = username;
        	return this;
        }

        public UserBuilder firstName(String firstname) {
            this.firstName = firstname;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder address(String address) {
        	this.address = address;
        	return this;
        }
        
        public UserBuilder password(String password) {
            this.password = password; // Add method to set password
            return this;
        }

//        public UserBuilder roles(Collection<Role> roles) {
//            this.roles = roles;
//            return this;
//        }
        public UserBuilder role(Role role) {
        	this.role = role;
        	return this;
        }

        public User build() {
            return new User(id, username, firstName, lastName, email, address, password, role);
        }
        
        public String toString() {
//            return "User.UserBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", address=" + this.address + ", email=" + this.email + ", password=" + this.password + ", roles=" + this.roles + ")";
            return "User.UserBuilder(id=" + this.id + ", username=" + this.username + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", address=" + this.address + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ")";
        }    
    }
}
