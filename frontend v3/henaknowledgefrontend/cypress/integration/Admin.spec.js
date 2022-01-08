/// <reference types="cypress"/>

it("test the shouted name", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get('.movingtext').contains('Welcome user')
})

it("check nagivation bar text", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(1) > a > span').contains("Chat")
    cy.get(':nth-child(2) > a > span').contains("Login")
})

it("move to the login page", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
})

it("Login to the Admin Page", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
})


it("Check Admin navigation bar", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(3) > a').contains('Sign up a student')
    cy.get(':nth-child(4) > a').contains('Sign up a teacher')
    cy.get(':nth-child(5) > a').contains('Remove a teacher')
    cy.get(':nth-child(6) > a').contains('Remove a student')
    cy.get(':nth-child(7) > a').contains('Student Statistics')
    cy.get(':nth-child(8) > a').contains('Teacher Statistics')
    cy.get(':nth-child(9) > a').contains('Points Settings')
})

it("Navigation to Add student", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(3) > a').contains('Sign up a student')
    cy.get(':nth-child(3) > a').click()
})

it("Navigation to Add teacher", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(4) > a').contains('Sign up a teacher')
    cy.get(':nth-child(4) > a').click()
})

it("Navigation to remove a teacher", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(5) > a').contains('Remove a teacher')
    cy.get(':nth-child(5) > a').click()
})

it("Navigation to remove a student", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(6) > a').contains('Remove a student')
    cy.get(':nth-child(6) > a').click()
})

it("Navigation to student statistics", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(7) > a').contains('Student Statistics')
    cy.get(':nth-child(7) > a').click()
})

it("Navigation to teacher statistics", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(8) > a').contains('Teacher Statistics')
    cy.get(':nth-child(8) > a').click()
})

it("Navigation to Points Settings", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('ADMIN')
    cy.get(':nth-child(5) > input').type('ADMIN')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(9) > a').contains('Points Settings')
    cy.get(':nth-child(9) > a').click()
})