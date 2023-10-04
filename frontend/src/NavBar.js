import React from 'react';
import { Link } from 'react-router-dom';

function NavBar() {
    return (
        <nav>
            <ul>
                <li>
                    <Link to="/">home</Link>
                </li>
                <li>
                    <Link to="/about">about</Link>
                </li>
                <li>
                    <Link to="/plants">plants</Link>
                </li>
                <li>
                    <Link to="/gardens">gardens</Link>
                </li>
                <li>
                    <Link to="/contact">contact</Link>
                </li>
                <li>
                    <Link to="/register">register</Link>
                </li>
                <li>
                    <Link to="/login">login</Link>
                </li>
            </ul>
        </nav>
    );
}

export default NavBar;
