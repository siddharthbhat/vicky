// Sample data (replace with your actual data)
const temperatureData = [20, 22, 25, 24, 23, 22, 21];
const humidityData = [50, 55, 60, 58, 55, 52, 51];
const noiseLevelData = [40, 45, 50, 48, 46, 43, 42];
const occupancyData = [10, 5, 20, 38, 37, 35, 64];
const EnergyConsumptiondata = [10, 5, 20, 38, 37, 35, 64];
const parkingAvailabilityData = [80, 78, 75, 73, 70, 68, 65];


// Chart.js configurations
const temperatureCtx = document.getElementById('temperatureChart').getContext('2d');
const humidityCtx = document.getElementById('humidityChart').getContext('2d');
const noiseLevelCtx = document.getElementById('noiseLevelChart').getContext('2d');
const occupancyCtx = document.getElementById('occupancyChart').getContext('2d');
const EnergyConsumptionChartCtx = document.getElementById('EnergyConsumptionChart').getContext('2d');
const parkingAvailabilityCtx = document.getElementById('parkingAvailabilityChart').getContext('2d');


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
                'rgba(55, 19, 12, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 99, 132, 0.2)'
            ],
            borderColor: [
                'rgba(55, 19, 12, 1)',
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
const EnergyConsumptionChart = new Chart(EnergyConsumptionChartCtx, {
    type: 'bar',
    data: {
        labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
        datasets: [{
            label: 'Energy (kW)',
            data: EnergyConsumptiondata,
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
                    labelString: 'Energy (kW)'
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

const parkingAvailabilityChart = new Chart(parkingAvailabilityCtx, {
  type: 'polarArea',
  data: {
      labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
      datasets: [{
          label: 'Parking Availability (%)',
          data: parkingAvailabilityData,
          backgroundColor: [
              'rgba(255, 99, 132, 0.5)',
              'rgba(54, 162, 235, 0.5)',
              'rgba(255, 206, 86, 0.5)',
              'rgba(75, 192, 192, 0.5)',
              'rgba(153, 102, 255, 0.5)',
              'rgba(255, 159, 64, 0.5)',
              'rgba(255, 99, 132, 0.5)'
          ],
          borderColor: [
              'rgba(255, 99, 132, 1)',
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
      scale: {
          ticks: {
              beginAtZero: true,
              max: 100
          }
      }
  }
});


// Sample JavaScript code for handling the staff dashboard functionality
document.addEventListener('DOMContentLoaded', function() {
    const intervalSelect = document.getElementById('interval');
    intervalSelect.addEventListener('change', function() {
        const selectedInterval = intervalSelect.value;
        // Perform actions based on the selected interval
        // For example, update chart data based on the selected time interval
        updateChartData(selectedInterval);
    });
});

function updateChartData(interval) {
    // Generate new data based on the selected interval
    const newData = generateData(interval);

    // Update chart data and labels for each sensor
    updateChart(temperatureChart, newData.temperature, newData.labels);
    updateChart(humidityChart, newData.humidity, newData.labels);
    updateChart(noiseLevelChart, newData.noiseLevel, newData.labels);
    updateChart(occupancyChart, newData.occupancy, newData.labels);
    updateChart(EnergyConsumptionChart, newData.energy, newData.labels);
    updateChart(parkingAvailabilityChart, newData.energy, newData.labels);

}

function updateChart(chart, data, labels) {
    // Update chart data and labels
    chart.data.datasets[0].data = data;
    chart.data.labels = labels;

    // Update the chart
    chart.update();
}

function generateData(interval) {
    // Generate data based on the selected interval
    let data = {};
    switch (interval) {
        case 'hourly':
            data.labels = Array.from({ length: 24 }, (_, i) => `${i}:00`);
            break;
        case 'daily':
            data.labels = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
            break;
        case 'weekly':
            data.labels = ['Three Weeks Ago', 'Two Weeks Ago', 'Last Week', 'This Week'];
            break;
    }

    // Generate random data for each sensor
    data.temperature = generateRandomData(data.labels.length, 20, 30);
    data.humidity = generateRandomData(data.labels.length, 40, 60);
    data.noiseLevel = generateRandomData(data.labels.length, 30, 50);
    data.occupancy = generateRandomData(data.labels.length, 20, 40);
    data.energy = generateRandomData(data.labels.length, 30,80);
    data.parking = generateRandomData(data.labels.length, 30,90);


    return data;
}

function generateRandomData(numPoints, min, max) {
    // Generate random data within the specified range
    return Array.from({ length: numPoints }, () => Math.floor(Math.random() * (max - min + 1)) + min);
}
// function updateChartData(interval) {
//     // Simulate fetching data from the server based on the selected interval
//     // Replace this with actual data fetching logic from your server
//     const newData = generateRandomData(interval);

//     // Update chart data with the new data
//     temperatureChart.data.datasets[0].data = newData.temperature;
//     humidityChart.data.datasets[0].data = newData.humidity;
//     noiseLevelChart.data.datasets[0].data = newData.noiseLevel;
//     occupancyChart.data.datasets[0].data = newData.occupancy;

//     // Update the chart
//     temperatureChart.update();
//     humidityChart.update();
//     noiseLevelChart.update();
//     occupancyChart.update();
// }


// // Function to generate random data for demonstration purposes
// function generateRandomData(interval) {
//     const data = {
//         temperature: [],
//         humidity: [],
//         noiseLevel: [],
//         occupancy: []
//     };

//     // Generate random data based on the selected interval
//     // For demonstration, generate random numbers between 20 and 30 for temperature,
//     // between 40 and 60 for humidity, between 30 and 50 for noise level,
//     // and between 20 and 40 for occupancy
//     const numDataPoints = 7; // Assuming 7 data points for each interval

//     for (let i = 0; i < numDataPoints; i++) {
//         data.temperature.push(Math.floor(Math.random() * (30 - 20 + 1)) + 20);
//         data.humidity.push(Math.floor(Math.random() * (60 - 40 + 1)) + 40);
//         data.noiseLevel.push(Math.floor(Math.random() * (50 - 30 + 1)) + 30);
//         data.occupancy.push(Math.floor(Math.random() * (40 - 20 + 1)) + 20);
//     }

//     return data;
// }


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