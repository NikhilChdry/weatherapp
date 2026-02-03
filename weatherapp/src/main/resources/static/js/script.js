function getWeather() {
    let city = document.getElementById("city").value;

    if (city === "") {
        document.getElementById("result").innerHTML = "⚠️ Please enter a city";
        return;
    }

fetch("/weather?city=" + city)
        .then(res => res.json())
        .then(data => {

            let html = `
                <h2>📍 ${data.city}, ${data.country}</h2>
                <p>🌡 Temperature: ${data.temperature} °C</p>
                <p>🤒 Feels Like: ${data.feelsLike} °C</p>
                <p>🌥 Condition: ${data.condition}</p>
                <p>💧 Humidity: ${data.humidity} %</p>
                <p>🌬 Wind: ${data.windSpeed} km/h</p>
            `;

            let card = document.getElementById("result");
            card.innerHTML = html;
            card.style.display = "block";
        })

        .catch(err => {
            document.getElementById("result").innerHTML =
                "❌ City not found or server error";
        });
}


document.addEventListener("DOMContentLoaded", function () {

    const themeSwitch = document.getElementById("themeSwitch");

    themeSwitch.addEventListener("change", () => {
        document.body.classList.toggle("dark");

        if (document.body.classList.contains("dark")) {
            localStorage.setItem("theme", "dark");
        } else {
            localStorage.setItem("theme", "light");
        }
    });

    // Load saved theme
    if (localStorage.getItem("theme") === "dark") {
        document.body.classList.add("dark");
        themeSwitch.checked = true;
    }
});

