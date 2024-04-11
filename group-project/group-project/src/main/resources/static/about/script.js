// Function to check session and redirect
function checkSession() {
    const userType = localStorage.getItem('userType'); // Retrieve user type from localStorage

    if (userType === 'student') {
        window.location.href = '../student/student.html'; // Redirect to student dashboard if logged in as student
    } else if (userType === 'staff') {
        window.location.href = '../staff/staff.html'; // Redirect to staff dashboard if logged in as staff
    }
    else{
        window.location.href = '../index.html'; // Redirect to login page if not logged in
    }
}

// Function to toggle login/logout button and update header text
function toggleLogin() {
    const userType = localStorage.getItem('userType'); // Retrieve user type from localStorage
    const loginLogoutBtn = document.getElementById('loginLogoutBtn');

    if (userType) {
        // If user is logged in, set button text to "Logout"
        loginLogoutBtn.innerHTML = '<a href="#" onclick="logout()">Logout</a>';
    } else {
        // If user is not logged in, set button text to "Login"
        loginLogoutBtn.innerHTML = '<a href="#" onclick="login()">Login</a>';
    }
}

// Call toggleLogin() function when each page is loaded
document.addEventListener('DOMContentLoaded', function() {
    toggleLogin();
});


function login() {
    window.location.href = '../login/login.html'; // Redirect to login page
}

// Function to clear session and redirect to index page
function logout() {
    localStorage.removeItem('userType'); // Clear user type from localStorage
    window.location.href = '../index.html'; // Redirect to index page after logout
}