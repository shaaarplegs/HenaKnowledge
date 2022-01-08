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

it("Login to the Student Page", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
})

it("Check Student navigation bar", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(3) > a').contains('Update personal information')
    cy.get(':nth-child(4) > a').contains('Your points')
    cy.get(':nth-child(5) > a').contains('Teachers contact')
    cy.get(':nth-child(6) > a').contains('Contact history')
    cy.get(':nth-child(7) > a').contains('Share Experience')
    cy.get(':nth-child(8) > a').contains('Experiences')
})

it("navigation to Update information page ", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(3) > a').contains('Update personal information')
    cy.get(':nth-child(3) > a').click()
})

it("navigation to Points page ", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(4) > a').contains('Your points')
    cy.get(':nth-child(4) > a').click()
})


it("navigation to Teacher Contact page ", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(5) > a').contains('Teachers contact')
    cy.get(':nth-child(5) > a').click()
})


it("navigation to Contact History page ", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(6) > a').contains('Contact history')
    cy.get(':nth-child(6) > a').click()
})

it("navigation to Share Experience ", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(7) > a').contains('Share Experience')
    cy.get(':nth-child(7) > a').click()
})


it("navigation to All Experiences ", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(8) > a').contains('Experiences')
    cy.get(':nth-child(8) > a').click()
})



