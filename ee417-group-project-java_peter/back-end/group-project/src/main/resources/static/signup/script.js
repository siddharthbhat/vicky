document.addEventListener("DOMContentLoaded", function() {
    const roleSelect = document.getElementById("role");
    const staffIdInput = document.getElementById("staffId");
    const studentIdInput = document.getElementById("studentId");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
  
    roleSelect.addEventListener("change", function() {
      if (roleSelect.value === "staff") {
        staffIdInput.classList.remove("hidden");
        studentIdInput.classList.add("hidden");
      } else if (roleSelect.value === "student") {
        studentIdInput.classList.remove("hidden");
        staffIdInput.classList.add("hidden");
      } else {
        staffIdInput.classList.add("hidden");
        studentIdInput.classList.add("hidden");
      }
    });
  
    emailInput.addEventListener("input", function() {
      const email = emailInput.value;
      if (!isValidEmail(email)) {
        emailInput.setCustomValidity("Please enter a valid email address.");
      } else {
        emailInput.setCustomValidity("");
      }
    });
  
    passwordInput.addEventListener("input", function() {
      const password = passwordInput.value;
      if (password.length < 8) {
        passwordInput.setCustomValidity("Password must be at least 8 characters long.");
      } else {
        passwordInput.setCustomValidity("");
      }
    });
  
    function isValidEmail(email) {
      // Basic email validation regex
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      return emailRegex.test(email);
    }
  });
  
  document.addEventListener("DOMContentLoaded", function() {
    const signupForm = document.getElementById("signup-form");
  
    signupForm.addEventListener("submit", function(event) {
      event.preventDefault(); // Prevent default form submission
  
      if (validateForm()) {
        const formData = {
          name: document.getElementById("name").value,
          email: document.getElementById("email").value,
          password: document.getElementById("password").value,
          role: document.getElementById("role").value,
          staffId: document.getElementById("staffIdInput").value,
          studentId: document.getElementById("studentIdInput").value
        };
  
        sendDataToAPI(formData);
      } else {
        alert("Please fill in all fields correctly.");
      }
    });
  
    function validateForm() {
      const name = document.getElementById("name").value;
      const email = document.getElementById("email").value;
      const password = document.getElementById("password").value;
      const role = document.getElementById("role").value;
  
      if (name.trim() === "" || email.trim() === "" || password.trim() === "" || role === "") {
        return false;
      }
  
      if (role === "staff") {
        const staffId = document.getElementById("staffIdInput").value;
        if (!/^\d{1,8}$/.test(staffId)) {
          return false;
        }
      } else if (role === "student") {
        const studentId = document.getElementById("studentIdInput").value;
        if (!/^\d{1,8}$/.test(studentId)) {
          return false;
        }
      }
  
      return true;
    }
  
    function sendDataToAPI(formData) {
      // You can perform an API call here to send the form data
      // For demonstration purposes, we'll log the data to the console
      console.log("Form Data:", formData);
      // Here you can use Fetch API or any other method to send data to your API endpoint
      // Example:
      fetch("https://127.0.0.1:3306/user/new", {
         method: 'POST',
         body: JSON.stringify(formData),
         headers: {
           'Content-Type': 'application/json'
         }
       })
       .then(response => response.json())
       .then(data => {
           alert("User successfully created!");
           // Clear form fields
           document.getElementById("signup-form").reset();

           // Redirect to the home page
           window.location.href = "../index.html";
       })
       .catch(error => console.error('Error:', error));
    }
  });
  