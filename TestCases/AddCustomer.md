# Customer Management Test Cases

## Project Information

| Property | Value |
|----------|-------|
| **Application** | SmartBank LoanApp |
| **Module** | Customer Management |
| **Document Type** | Manual Test Cases |
| **Author** | Ihor Tovt |
| **Version** | 1.0 |

---

## Scope

This document contains manual test cases for the **Customer Management** module of the SmartBank LoanApp application.

The test suite covers:

- UI validation
- Positive scenarios
- Negative scenarios
- Boundary Value Analysis (BVA)
- Equivalence Partitioning (EP)
- Field validation
- Business rule validation
- Customer creation workflow

---

## Common Preconditions

- The SmartBank LoanApp application is running.
- The user is authenticated as **Administrator**.
- Branch: **Halifax**.
- The **Add Customer** page is open.
- Unless stated otherwise, all unspecified fields contain valid values.

---

# Test Cases

---

## TC-CUS-001 — Verify Add Customer page layout

**Priority:** Medium

**Type:** UI Testing

**Technique:** UI Validation

### Steps

1. Navigate to the **Customers** page.
2. Click **Add Customer**.
3. Observe all visible page elements.

### Expected Result

- The **Add Customer** page is displayed successfully.
- The following input fields are available:
    - Account #
    - Title
    - First Name
    - Last Name
    - Street
    - City
    - Province
    - Postal Code
    - Telephone
    - E-mail
- The following action buttons are displayed:
    - Save
    - Save & Add Another
    - Cancel

---

## TC-CUS-002 — Verify successful customer creation with valid data

**Priority:** Critical

**Type:** Functional Testing

**Technique:** Positive Testing

### Preconditions

Customer account **1234567** does not already exist.

### Test Data

| Field | Value |
|------|------|
| Account # | 1234567 |
| Title | Miss |
| First Name | Ihor |
| Last Name | Tovt |
| Street | 25 Yonge Street |
| City | Toronto |
| Province | Ontario |
| Postal Code | M5E1W7 |
| Phone | (201)005-4568 |
| Email | ihor.tovt@test.com |

### Steps

1. Populate all customer fields with valid values.
2. Click **Save**.

### Expected Result

- The customer is successfully created.
- The application navigates to the **Customers** page.
- The newly created customer appears in the Customers table with the correct Account # and customer information.

---

## TC-CUS-003 — Verify Account # is a required field

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Account # | *(empty)* |
| First Name | Ihor |
| Last Name | Tovt |

### Steps

1. Leave the **Account #** field empty.
2. Enter valid values into all remaining required fields.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Account #' field is required."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

## TC-CUS-004 — Verify First Name is a required field

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Account # | 1234568 |
| First Name | *(empty)* |
| Last Name | Tovt |

### Steps

1. Enter a valid Account #.
2. Leave the **First Name** field empty.
3. Enter a valid Last Name.
4. Click **Save**.

### Expected Result

- Validation message:

  **"The 'First Name' field is required."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

## TC-CUS-005 — Verify Last Name is a required field

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Account # | 1234569 |
| First Name | Ihor |
| Last Name | *(empty)* |

### Steps

1. Enter a valid Account #.
2. Enter a valid First Name.
3. Leave the **Last Name** field empty.
4. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Last Name' field is required."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

---

## TC-CUS-006 — Verify a customer cannot be created with a duplicate Account #

**Priority:** High

**Type:** Validation Testing

**Technique:** Negative Testing

### Preconditions

A customer with **Account # 1234567** already exists in the system.

### Test Data

| Field | Value |
|------|------|
| Account # | 1234567 |
| First Name | Ihor |
| Last Name | Tovt |

### Steps

1. Enter an existing Account #.
2. Enter valid values into all remaining required fields.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Account #' already exists."**

  is displayed.

- The Add Customer page remains open.
- No duplicate customer record is created.

---

## TC-CUS-007 — Verify minimum allowed values are accepted

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Lower Boundary)

### Preconditions

Customer account **1234570** does not already exist.

### Test Data

| Field | Value |
|------|------|
| Account # | 1234570 |
| First Name | A |
| Last Name | B |

### Steps

1. Enter the minimum valid values for all required fields.
2. Leave all optional fields empty.
3. Click **Save**.

### Expected Result

- The customer is successfully created.
- The application navigates to the **Customers** page.
- The newly created customer appears in the Customers table.

---

## TC-CUS-008 — Verify maximum allowed field lengths

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary)

### Preconditions

Customer account **1234571** does not already exist.

### Test Data

| Field | Value |
|------|------|
| Account # | 1234571 |
| Title | Miss |
| First Name | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA |
| Last Name | BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB |
| Street | CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC |
| City | DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD |
| Province | Ontario |
| Postal Code | A1B2C3D |
| Phone | (601)005-4568 |
| Email | maxuser32@testcompany.com |

### Steps

1. Populate every field using its maximum allowed valid length.
2. Click **Save**.

### Expected Result

- All entered values are accepted.
- The customer is successfully created.
- The application navigates to the **Customers** page.
- The newly created customer appears in the Customers table.

---

## TC-CUS-009 — Verify Account # below minimum length is rejected

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Lower Boundary − 1)

### Test Data

| Field | Value |
|------|------|
| Account # | 123456 *(6 digits)* |
| First Name | Ihor |
| Last Name | Tovt |

### Steps

1. Enter a six-digit Account #.
2. Enter valid values into all remaining required fields.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Account #' must be 7 digits long."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

## TC-CUS-010 — Verify Account # maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Account # | 12345678 *(8 digits)* |

### Steps

1. Attempt to enter an Account # longer than the maximum allowed length.

### Expected Result

- The **Account #** field accepts no more than **7 digits**.
- Additional digits beyond the maximum limit are ignored.

---

## TC-CUS-011 — Verify First Name maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| First Name | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA *(33 characters)* |

### Steps

1. Attempt to enter a First Name exceeding the maximum allowed length.

### Expected Result

- The **First Name** field accepts no more than **32 characters**.
- Additional characters beyond the maximum limit are ignored.

---

---

## TC-CUS-012 — Verify Last Name maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Last Name | BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB *(33 characters)* |

### Steps

1. Attempt to enter a Last Name exceeding the maximum allowed length.

### Expected Result

- The **Last Name** field accepts no more than **32 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-CUS-013 — Verify Street maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Street | CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC *(33 characters)* |

### Steps

1. Attempt to enter a Street value exceeding the maximum allowed length.

### Expected Result

- The **Street** field accepts no more than **32 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-CUS-014 — Verify City maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| City | DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD *(33 characters)* |

### Steps

1. Attempt to enter a City value exceeding the maximum allowed length.

### Expected Result

- The **City** field accepts no more than **32 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-CUS-015 — Verify Postal Code maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Postal Code | A1B2C3D4 *(8 characters)* |

### Steps

1. Attempt to enter a Postal Code exceeding the maximum allowed length.

### Expected Result

- The **Postal Code** field accepts no more than **7 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-CUS-016 — Verify Account # accepts numeric characters only

**Priority:** Medium

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Account # | 12A45#7 |
| First Name | Ihor |
| Last Name | Tovt |

### Steps

1. Enter an Account # containing alphabetic and special characters.
2. Enter valid values into all remaining required fields.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Account #' can only contain numbers."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

## TC-CUS-017 — Verify First Name accepts alphabetic characters only

**Priority:** Medium

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Account # | 1234572 |
| First Name | Ihor123 |
| Last Name | Tovt |

### Steps

1. Enter a First Name containing numeric characters.
2. Enter valid values into all remaining required fields.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'First Name' can only contain letters and spaces."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

---

## TC-CUS-018 — Verify Last Name accepts alphabetic characters only

**Priority:** Medium

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Account # | 1234573 |
| First Name | Ihor |
| Last Name | Tovt123 |

### Steps

1. Enter a valid Account #.
2. Enter a valid First Name.
3. Enter a Last Name containing numeric characters.
4. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Last Name' can only contain letters and spaces."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

## TC-CUS-019 — Verify Phone Number format validation

**Priority:** Medium

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Format)

### Test Data

| Field | Value |
|------|------|
| Account # | 1234574 |
| First Name | Ihor |
| Last Name | Tovt |
| Phone | 123456789 |

### Steps

1. Enter valid values into all required fields.
2. Enter an invalid Phone Number.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The phone number must be in the (999)999-9999 format."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

## TC-CUS-020 — Verify Email format validation

**Priority:** Medium

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Format)

### Test Data

| Field | Value |
|------|------|
| Account # | 1234575 |
| First Name | Ihor |
| Last Name | Tovt |
| Email | invalid@email |

### Steps

1. Enter valid values into all required fields.
2. Enter an invalid Email address.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Email' field must be a valid email address."**

  is displayed.

- The Add Customer page remains open.
- No customer record is created.

---

## TC-CUS-021 — Verify Cancel button functionality

**Priority:** Medium

**Type:** Functional Testing

**Technique:** Positive Testing

### Steps

1. Enter values into one or more fields.
2. Click **Cancel**.

### Expected Result

- The application navigates back to the **Customers** page.
- All entered data is discarded.
- No customer record is created.

---

## TC-CUS-022 — Verify "Save & Add Another" functionality

**Priority:** Medium

**Type:** Functional Testing

**Technique:** Positive Testing

### Preconditions

Customer account **1234576** does not already exist.

### Test Data

| Field | Value |
|------|------|
| Account # | 1234576 |
| First Name | Ihor |
| Last Name | Tovt |

### Steps

1. Populate all required fields with valid values.
2. Click **Save & Add Another**.

### Expected Result

- The customer is successfully created.
- A confirmation notification is displayed.
- The **Add Customer** page remains open.
- All input fields are cleared.
- The form is ready for creating another customer.

---