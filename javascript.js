document.getElementById('contact-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Form submitted successfully!');

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const message = document.getElementById('message').value;

    console.log(Name: ${name}, Email: ${email}, Message: ${message});

    document.getElementById('contact-form').reset();
});