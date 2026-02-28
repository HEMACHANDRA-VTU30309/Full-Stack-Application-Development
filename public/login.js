console.log("JS Loaded Successfully");

const form = document.getElementById("loginForm");

form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const response = await fetch("/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password })
    });

    const data = await response.json();

    if (data.success) {
        window.location.href = "/dashboard";
    } else {
        document.getElementById("errorMsg").innerText = data.message;
    }
});