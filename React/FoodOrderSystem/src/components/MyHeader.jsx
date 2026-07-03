import React from "react";
import { Navbar, Nav, Container } from "react-bootstrap";
import Logo from "../assets/logo1.png";
import { Link } from "react-router-dom";
import { Bag } from "react-bootstrap-icons";

const MyHeader = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg" className="shadow-sm py-3">
      <Container>
        <Navbar.Brand
          as={Link}
          to="/"
          className="d-flex align-items-center gap-2"
        >
          <img
            src={Logo}
            alt="logo"
            width="45"
            height="45"
            className="rounded"
          />
          <span className="fw-bold fs-4">Foodie</span>
        </Navbar.Brand>

        <Nav className="ms-auto align-items-center gap-4">
          <Nav.Link as={Link} to="/" className="fs-5">
            Home
          </Nav.Link>

          <Nav.Link as={Link} to="/order" className="fs-5">
            Orders
          </Nav.Link>

          <Nav.Link as={Link} to="/cart" className="position-relative">
            <Bag size={28} />
          </Nav.Link>
        </Nav>
      </Container>
    </Navbar>
  );
};

export default MyHeader;
