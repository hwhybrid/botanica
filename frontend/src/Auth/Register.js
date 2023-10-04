import React, { useState } from 'react';
import axios from 'axios';

const Register = () => {
    const [userData, setUserData] = useState({
        username: '',
        password: '',
        email: '',
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setUserData({ ...userData, [name]: value });
    };

    const handleRegistration = async () => {
        try {
            const response = await axios.post('/api/auth/register', userData);
            console.log(response.data); // Success message from the backend
        } catch (error) {
            console.error('Registration failed:', error);
        }
    };

    return (
        <div>
            <h2>Registration</h2>
            <form>
                <input
                    type="text"
                    name="username"
                    placeholder="Username"
                    onChange={handleInputChange}
                />
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    onChange={handleInputChange}
                />
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    onChange={handleInputChange}
                />
                <button type="button" onClick={handleRegistration}>
                    Register
                </button>
            </form>
        </div>
    );
};

export default Register;
