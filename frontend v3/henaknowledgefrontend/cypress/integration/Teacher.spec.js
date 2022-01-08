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

it("Login to the Teacher Page", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('d2c9xjf75wa049bqzvnmo8')
    cy.get(':nth-child(5) > input').type('odtpj3qfljydyigvjah')
    cy.get('.LoginBtn').click()
})


it("Check Teacher navigation bar", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(3) > a').contains('Update personal information')
    cy.get(':nth-child(4) > a').contains('Your points')
    cy.get(':nth-child(6) > a').contains('Contact history')
    cy.get(':nth-child(7) > a').contains('Share Experience')
    cy.get(':nth-child(8) > a').contains('Experiences')
})

it("Navigate to Update personal Information", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(3) > a').contains('Update personal information')
    cy.get(':nth-child(3) > a').click()
})

it("Navigate to your points page", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(4) > a').contains('Your points')
    cy.get(':nth-child(4) > a').click()
})

it("Navigate to Contact History", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(6) > a').contains('Contact history')
    cy.get(':nth-child(6) > a').click()
})    

it("Navigate to share experiences", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(7) > a').contains('Share Experience')
    cy.get(':nth-child(7) > a').click()
})    

it("Navigate to experiences", ()=> {
    cy.visit('http://localhost:3000/')
    cy.get(':nth-child(2) > a > span').click()
    cy.get(':nth-child(4) > input').type('maja')
    cy.get(':nth-child(5) > input').type('maja')
    cy.get('.LoginBtn').click()
    cy.get(':nth-child(8) > a').contains('Experiences')
    cy.get(':nth-child(8) > a').click()
})    