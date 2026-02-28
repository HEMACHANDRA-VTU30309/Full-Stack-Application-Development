require("dotenv").config();

const express = require("express");
const mysql = require("mysql2");
const path = require("path");

const app = express();

// Middleware
app.use(express.json());
app.use(express.static(path.join(__dirname, "public")));
app.set("view engine", "ejs");

// Database Connection
const db = mysql.createConnection({
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME
});

db.connect(err => {
    if (err) {
        console.error("DB Error:", err);
        return;
    }
    console.log("Connected to Database");
});

// Route for Home
app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, "public", "login.html"));
});
app.use(express.urlencoded({ extended: true }));

// Login Route
app.post("/login", (req, res) => {
    const { email, password } = req.body;

    const sql = "SELECT * FROM students WHERE email=? AND password=?";

    db.query(sql, [email, password], (err, result) => {
        if (err) return res.send("Server Error");

        if (result.length > 0) {
            res.redirect("/dashboard");   // Redirect directly
        } else {
            res.send("Invalid Email or Password");
        }
    });
});

// Dashboard
app.get("/dashboard", (req, res) => {
    res.render("dashboard");
});

app.listen(process.env.PORT || 3000, () => {
    console.log("Server running on port 3000");
});