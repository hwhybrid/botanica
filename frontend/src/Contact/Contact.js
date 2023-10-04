// Contact.js
import React, { useState } from 'react';

function Contact() {
    const [message, setMessage] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        // Send the message to your backend using an API call
        // Implement this API function
    };

    return (
        <div>
            <h1>Contact Us</h1>
            <form onSubmit={handleSubmit}>
        <textarea
            rows="4"
            cols="50"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            placeholder="Type your message here..."
        ></textarea>
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default Contact;
