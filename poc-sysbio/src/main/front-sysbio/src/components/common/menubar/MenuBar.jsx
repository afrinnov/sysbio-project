import {Container, Navbar, Nav, NavDropdown } from "solid-bootstrap"

function MenuBar () {
    return (
        <Navbar bg="light" expand="lg">
  <Container>
    <Navbar.Brand href="#home">SYSBIO</Navbar.Brand>
    <Navbar.Toggle aria-controls="basic-navbar-nav" />
    <Navbar.Collapse id="basic-navbar-nav">
      <Nav class="me-auto">
        <Nav.Link href="/">Home</Nav.Link>        
        <Nav.Link href="/suscribers">Abonnements</Nav.Link>
        <NavDropdown title="User" id="basic-nav-dropdown">
          <NavDropdown.Item href="#">Profile</NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="about">ABout</NavDropdown.Item>
        </NavDropdown>
      </Nav>
    </Navbar.Collapse>
  </Container>
</Navbar>
    )
}

export default MenuBar