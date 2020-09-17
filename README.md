# Rocket_Elevators_GraphQL IN java
this link is use to do the Graphql request with a post method
```
https://relevator.herokuapp.com/graphql
```
This link is to test the java aplication
```
https://app.getpostman.com/join-team?invite_code=10287ab029d5fffab3cf93b8c69ee216&ws=d030f10c-555d-426b-b96e-9203535ccbb8
```

## Question 1: Get address of a building and information of a intervention
You can change the id of intervention. this id is the id of a intervention
```
query{intervention(id: 4){
  id
  building_id
  employee_id
  start_intervention
  end_intervention
  address{
    street
    suite
    city
    postalCode
    country
  }
}
}
```
## Question 2: Get all interventions of a building and the customer related to it
You can change the id by a id of building
```
query{buildings(id: 2){
  id
  customer{
    email
  }
  interventions{
    id
    building_id
    employee_id
    start_intervention
    end_intervention
  }
  address{
    street
    suite
    city
    postalCode
    country
  }
}
}
```

## Question 3: Get all interventions made by an employee
You can change id by a id of a employee
```
query{
    employee(id: 3){
  firstName
  lastName
  email
  title
  interventions{
    building_id
    start_intervention
    end_intervention
    build{
      fullName
      email
      cellPhone
      techName
      techEmail
      address{
        street
        city
        country
        postalCode
      }
      building_details{
        key
        value
      }
    }
    }
  }
}
```

## Intervention List
```
query{
  interventionList{
    id
    building_id
    employee_id
    start_intervention
    end_intervention
    address{
      street
      suite
      city
      postalCode
      country
    }
  }
}

```


## Intervention Update
You can change id by a intervention id and complete by one of [complete, inprogress]
```
mutation{
  updateIntervention(id: 3, status: "complete"){
    id
    building_id
    employee_id
    start_intervention
    end_intervention
    address{
      street
      suite
      city
      postalCode
      country
    }
  }
}


```

## Battery
You can change id by a id of a battery
```
query{
    battery(id: 5){
        id
        status
    }
}

```

You can change id by a id of a battery
You can change inactive by [active, inactive]
```
mutation{
    updateBattery(id: 5, status: "inactive"){
        id
        status
    }
}

```
## Column
You can change id by a id of a column
```
query{
    column(id: 5){
        id
        status
    }
}

```

You can change id by a id of a battery
You can change inactive by [active, inactive]
```
mutation{
    updateColumn(id: 5, status: "active"){
        id
        status
    }
}

```
## Elevator
You can change id by a id of a elevator
```
query{
    elevator(id: 5){
        id
        status
        serialNumber
        inspectionDate
        installDate
        certificat
        information
        note
        type
        column_id
        category_id
    }
}

```

You can change id by a id of a battery
You can change inactive by [active, inactive]
```
mutation{
    updateElevator(id: 5, status: "inactive"){
        id
        status
        serialNumber
        inspectionDate
        installDate
        certificat
        information
        note
        type
        column_id
        category_id
    }
}

```

## Elevator List
```
query{
    elevatorList{
        id
        status
        serialNumber
        inspectionDate
        installDate
        certificat
        information
        note
        type
        column_id
        category_id
    }
}

```

## Building List
```
query{
    buildList{
        id
        fullName
        email
        cellPhone
        techName
        techEmail
        techPhone
        address{
            street
        }
        customer_id
        building_details{
            key
            value
        }
    }
}
```
## Lead list

```
query{
    leads{
        id
        fullName
        entrepriseName
        cellPhone
        projectName
        description
        type
    }
}
```

## Customer
### get id of customer
```
query{
    customer(email: "francoise.rautenstrauch@rautenstrauch.com"){
        id
    }
}
```
### get all service of customers

```
query{
    cxbyCustomer(email: "elfrieda_hinsch@hinsch.org"){
        build{
            id
        }
        battery{
            id
            build_id
        }
        column{
            id
            battery_id
        }
        elevator{
            id
            column_id
        }
    }
}
```
### Update email of customer

```
mutation{
    updateEmail(email: "elfrieda_hinsch@hinsch.o", newEmail: "elfrieda_hinsch@hinsch.org"){
        id
    }
}
```

## intervention

```
mutation{
    addIntevention(customer: "leanna@cox.net", build: 4, battery: 0, column: 0, elevator: 0, description: "akki"){
        id
    }
}
```

## Address

### get address

```
query{
    addressbyCustomer(email: "leanna@cox.net"){
        id
        street
    }
}
```

### update address

```
mutation{
    UpdateAddress(id: 3, street: "12801 Saunders Road", suite: "", city: "anchorage", postalCode: "99516", country: "AK"){
        id
    }
}
```
