// Field elements
const nameField = document.getElementById('name');
const emailField = document.getElementById('email');
const messageField = document.getElementById('message');
const submitBtn = document.getElementById('submitBtn');

// Error message elements
const nameError = document.getElementById('nameError');
const emailError = document.getElementById('emailError');
const messageError = document.getElementById('messageError');

// Validation functions
function validateName() {
    const name = nameField.value.trim();
    if (!/^[a-zA-Z\s]{2,}$/.test(name)) {
        nameError.textContent = "Name must be at least 2 letters.";
        nameField.classList.add('is-invalid');
        nameField.classList.remove('is-valid');
    } else {
        nameError.textContent = "";
        nameField.classList.add('is-valid');
        nameField.classList.remove('is-invalid');
    }
    checkFormValidity();
}

function validateEmail() {
    const email = emailField.value.trim();
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!pattern.test(email)) {
        emailError.textContent = "Enter a valid email.";
        emailField.classList.add('is-invalid');
        emailField.classList.remove('is-valid');
    } else {
        emailError.textContent = "";
        emailField.classList.add('is-valid');
        emailField.classList.remove('is-invalid');
    }
    checkFormValidity();
}

function validateMessage() {
    const message = messageField.value.trim();
    if (message.length < 5) {
        messageError.textContent = "Message must be at least 5 characters.";
        messageField.classList.add('is-invalid');
        messageField.classList.remove('is-valid');
    } else {
        messageError.textContent = "";
        messageField.classList.add('is-valid');
        messageField.classList.remove('is-invalid');
    }
    checkFormValidity();
}

// Enable submit button only if all fields are valid
function checkFormValidity() {
    if (
        nameField.classList.contains('is-valid') &&
        emailField.classList.contains('is-valid') &&
        messageField.classList.contains('is-valid')
    ) {
        submitBtn.disabled = false;
    } else {
        submitBtn.disabled = true;
    }
}

// Submit form with Bootstrap modal
function submitForm() {
    const name = nameField.value.trim();
    const confirmationText = document.getElementById('confirmationText');
    confirmationText.textContent = `Thank you, ${name}! Your feedback has been submitted.`;

    // Show modal
    const confirmationModal = new bootstrap.Modal(document.getElementById('confirmationModal'));
    confirmationModal.show();

    // Reset form
    document.getElementById('feedbackForm').reset();
    nameField.classList.remove('is-valid', 'is-invalid');
    emailField.classList.remove('is-valid', 'is-invalid');
    messageField.classList.remove('is-valid', 'is-invalid');
    submitBtn.disabled = true;
}
