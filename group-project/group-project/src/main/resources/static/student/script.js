// Sample data (replace with your actual data)
let temperatureData = [20, 22, 25, 24, 23, 22, 21];
let humidityData = [50, 55, 60, 58, 55, 52, 51];
let noiseLevelData = [40, 45, 50, 48, 46, 43, 42];
let occupancyData = [10, 5, 20, 38, 37, 35, 64];
// GET Temperature Data
// GET Temperature Data
fetch('http://127.0.0.1:8080/temperature', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
})
    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log('temperature', data);
        temperatureData = data.map(entry => entry.temperature);
        // Update the chart with the new temperatureData
        temperatureChart.data.datasets[0].data = temperatureData;
        temperatureChart.update(); // Update the chart
    })
    .catch(error => {
        console.error('Error:', error);
    })

// GET room occupancy last 7 days Data
fetch('http://localhost:8080/occupancy/time?timeFrame=last7Days', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
})
    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log('occupancy time', data);
        // Update the occupancyData with the fetched data
        occupancyData = data.map(entry => entry.currentOccupancy);
        // Update the chart with the new occupancyData
        occupancyChart.data.datasets[0].data = occupancyData;
        occupancyChart.update(); // Update the chart
    })
    .catch(error => {
        console.error('Error:', error);
    })

// GET humidity Data
fetch('http://localhost:8080/humidity', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
})
    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log('humidity', data);
        humidityData = data.map(entry => entry.humidity);
        // Update the chart with the new humidityData
        humidityChart.data.datasets[0].data = humidityData;
        humidityChart.update(); // Update the chart
    })
    .catch(error => {
        console.error('Error:', error);
    })

// GET noise Data
fetch('http://localhost:8080/noise', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
})
    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log('noise', data);
        noiseLevelData = data.map(entry => entry.noiseLevelDB);
        // Update the chart with the new noiseLevelData
        noiseLevelChart.data.datasets[0].data = noiseLevelData;
        noiseLevelChart.update(); // Update the chart
    })
    .catch(error => {
        console.error('Error:', error);
    })

// Chart.js configurations
const temperatureCtx = document.getElementById('temperatureChart').getContext('2d');
const humidityCtx = document.getElementById('humidityChart').getContext('2d');
const noiseLevelCtx = document.getElementById('noiseLevelChart').getContext('2d');
const occupancyCtx = document.getElementById('occupancyChart').getContext('2d');

const temperatureChart = new Chart(temperatureCtx, {
  type: 'bar',
  data: {
    labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
    datasets: [{
      label: 'Temperature (°C)',
      data: temperatureData,
      backgroundColor: 'rgba(255, 99, 132, 0.2)',
      borderColor: 'rgba(255, 99, 132, 1)',
      borderWidth: 1
    }]
  },
  options: {
    scales: {
      yAxes: [{
        scaleLabel: {
          display: true,
          labelString: 'Temperature (°C)'
        },
        ticks: {
          beginAtZero: false
        }
      }],
      xAxes: [{
        scaleLabel: {
          display: true,
          labelString: 'Day'
        }
      }]
    }
  }
});

const humidityChart = new Chart(humidityCtx, {
  type: 'line',
  data: {
    labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
    datasets: [{
      label: 'Humidity (%)',
      data: humidityData,
      backgroundColor: 'rgba(54, 162, 235, 0.2)',
      borderColor: 'rgba(54, 162, 235, 1)',
      borderWidth: 1
    }]
  },
  options: {
    scales: {
      yAxes: [{
        scaleLabel: {
          display: true,
          labelString: 'Humidity (%)'
        },
        ticks: {
          beginAtZero: true
        }
      }],
      xAxes: [{
        scaleLabel: {
          display: true,
          labelString: 'Day'
        }
      }]
    }
  }
});

const noiseLevelChart = new Chart(noiseLevelCtx, {
  type: 'radar',
  data: {
    labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
    datasets: [{
      label: 'Noise Level (dB)',
      data: noiseLevelData,
      backgroundColor: 'rgba(75, 192, 192, 0.2)',
      borderColor: 'rgba(75, 192, 192, 1)',
      borderWidth: 1
    }]
  },
  options: {
    scale: {
      angleLines: {
        display: false
      },
      ticks: {
        beginAtZero: true
      }
    }
  }
});

const occupancyChart = new Chart(occupancyCtx, {
  type: 'pie',
  data: {
    labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
    datasets: [{
      label: 'Occupancy',
      data: occupancyData,
      backgroundColor: [
          'rgba(55, 59, 12, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)',
          'rgba(255, 99, 132, 0.2)'
      ],
      borderColor: [
          'rgba(55, 59, 12, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)',
          'rgba(255, 99, 132, 1)'
      ],
      borderWidth: 1
    }]
  },
  options: {
    scales: {
      yAxes: [{
        display: false
      }],
      xAxes: [{
        display: false
      }]
    }
  }
});

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