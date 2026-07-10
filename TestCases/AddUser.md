# User Management Test Cases

## Project Information

| Property | Value |
|----------|-------|
| **Application** | SmartBank LoanApp |
| **Module** | User Management |
| **Document Type** | Manual Test Cases |
| **Author** | Ihor Tovt |
| **Version** | 1.0 |

---

## Scope

This document contains manual test cases for the **User Management** module of the SmartBank LoanApp application.

The test suite covers:

- UI validation
- Positive scenarios
- Negative scenarios
- Boundary Value Analysis (BVA)
- Equivalence Partitioning (EP)
- Field validation
- Business rule validation

---

## Common Preconditions

- User is logged in as **Administrator**.
- Branch: **Halifax**
- The **Add User** page is open.
- Unless stated otherwise, all unspecified fields contain valid values.

---

# Test Cases

---

## TC-USR-001 — Verify Add User page layout

**Priority:** Medium

**Type:** UI Testing

**Technique:** UI Validation

### Steps

1. Open the **Add User** page.
2. Observe all page elements.

### Expected Result

- The page title is displayed correctly.
- The following input fields are available:
    - Username
    - Password
    - First Name
    - Last Name
    - Company
    - Phone Number
    - Email
- The **Branch Role** dropdown is displayed.
- The following buttons are visible:
    - Save
    - Save & Add Another
    - Cancel

---

## TC-USR-002 — Verify successful user creation with valid data

**Priority:** Critical

**Type:** Functional Testing

**Technique:** Positive Testing

### Preconditions

The username **user_valid_01** does not already exist.

### Test Data

| Field | Value |
|------|------|
| Username | user_valid_01 |
| Password | Password123 |
| First Name | Ihor |
| Last Name | Tovt |
| Company | Novum |
| Phone | (343)323-4543 |
| Email | user_valid_01@test.com |

### Steps

1. Enter valid data into all required fields.
2. Click **Save**.

### Expected Result

- The user is successfully created.
- A confirmation notification with the text **"Created"** is displayed.
- The user record appears in the **Users** table.

---

## TC-USR-003 — Verify Username is a required field

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Username | *(empty)* |
| Password | Password123 |

### Steps

1. Leave the **Username** field empty.
2. Enter a valid password.
3. Click **Save**.

### Expected Result

- Validation message **"Please correct errors before saving this form."** is displayed.
- The Username field is highlighted.
- No user record is created.

---

## TC-USR-004 — Verify Password is a required field

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Username | user_required_password |
| Password | *(empty)* |

### Steps

1. Enter a valid username.
2. Leave the Password field empty.
3. Click **Save**.

### Expected Result

- Validation message **"Please correct errors before saving this form."** is displayed.
- The Password field is highlighted.
- No user record is created.

---

## TC-USR-005 — Verify a user cannot be created with a duplicate username

**Priority:** High

**Type:** Validation Testing

**Technique:** Negative Testing

### Preconditions

- A user with username **existing_user_01** already exists in the system.

### Test Data

| Field | Value |
|------|------|
| Username | existing_user_01 |
| Password | Password123 |

### Steps

1. Enter an existing username.
2. Enter a valid password.
3. Populate all remaining required fields with valid data.
4. Click **Save**.

### Expected Result

- Validation message **"The username already exists."** is displayed.
- The Add User page remains open.
- No duplicate user record is created.

---

## TC-USR-006 — Verify minimum allowed Username length

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Lower Boundary)

### Preconditions

The username **a** does not already exist.

### Test Data

| Field | Value |
|------|------|
| Username | a |
| Password | Password123 |

### Steps

1. Enter a one-character username.
2. Enter valid values into all remaining required fields.
3. Click **Save**.

### Expected Result

- The user is successfully created.
- A confirmation notification is displayed.
- The new user appears in the Users table.

---

## TC-USR-007 — Verify maximum allowed field lengths

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary)

### Test Data

| Field | Value |
|------|------|
| Username | user123456789012 |
| Password | Pass123456789012 |
| First Name | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA |
| Last Name | BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB |
| Company | CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC |
| Phone | (601)005-4568 |
| Email | maxuser32@testcompany.com |

### Steps

1. Populate every field using its maximum allowed valid length.
2. Click **Save**.

### Expected Result

- All entered values are accepted.
- The user is successfully created.
- A confirmation notification is displayed.
- The created user appears in the Users table.

---

## TC-USR-008 — Verify Password below minimum allowed length

**Priority:** High

**Type:** Validation Testing

**Technique:** Boundary Value Analysis (Lower Boundary - 1)

### Test Data

| Field | Value |
|------|------|
| Username | user_short_pwd |
| Password | Pass123 |

### Steps

1. Enter a valid username.
2. Enter a seven-character password.
3. Populate all remaining required fields with valid data.
4. Click **Save**.

### Expected Result

- Validation message indicating that the password must contain at least **8 characters** is displayed.
- The user is not created.

---

## TC-USR-009 — Verify Phone Number format validation

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Format)

### Test Data

| Field | Value |
|------|------|
| Username | invalid_phone_01 |
| Password | Password123 |
| Phone | 123456789 |

### Steps

1. Enter valid values into all required fields.
2. Enter an invalid phone number.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The phone number must be in the (999)999-9999 format."**

  is displayed.
- The user is not created.

---

## TC-USR-010 — Verify Username maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Username | user1234567890123 *(17 characters)* |

### Steps

1. Attempt to enter a username longer than the maximum allowed length.

### Expected Result

- The Username field accepts no more than **16 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-USR-011 — Verify Password maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Password | Pass1234567890123 *(17 characters)* |

### Steps

1. Enter a password longer than the maximum allowed length.

### Expected Result

- The Password field accepts no more than **16 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-USR-012 — Verify First Name maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| First Name | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA *(33 characters)* |

### Steps

1. Enter a first name exceeding the maximum allowed length.

### Expected Result

- The First Name field accepts no more than **32 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-USR-013 — Verify Last Name maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Last Name | BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB *(33 characters)* |

### Steps

1. Enter a last name exceeding the maximum allowed length.

### Expected Result

- The Last Name field accepts no more than **32 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-USR-014 — Verify Company maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Company | CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC *(33 characters)* |

### Steps

1. Enter a company name exceeding the maximum allowed length.

### Expected Result

- The Company field accepts no more than **32 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-USR-015 — Verify Phone Number maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Phone | 12345678910 *(11 digits)* |

### Steps

1. Enter a phone number longer than the maximum allowed length.

### Expected Result

- The Phone Number field accepts no more than **10 digits**.
- Additional digits beyond the maximum limit are ignored.


---

## TC-USR-016 — Verify Email maximum length restriction

**Priority:** Medium

**Type:** Boundary Testing

**Technique:** Boundary Value Analysis (Upper Boundary + 1)

### Test Data

| Field | Value |
|------|------|
| Email | verylongemailaddress123456789@test.com *(33+ characters)* |

### Steps

1. Enter an email address exceeding the maximum allowed length.

### Expected Result

- The Email field accepts no more than **32 characters**.
- Additional characters beyond the maximum limit are ignored.

---

## TC-USR-017 — Verify First Name accepts alphabetic characters only

**Priority:** Medium

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Username | invalid_fname_01 |
| Password | Password123 |
| First Name | John123@ |

### Steps

1. Populate all required fields with valid values.
2. Enter **John123@** into the First Name field.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'First Name' can only contain letters and spaces."**

  is displayed.
- The user record is not created.

---

## TC-USR-018 — Verify Last Name accepts alphabetic characters only

**Priority:** Medium

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Username | invalid_lname_01 |
| Password | Password123 |
| Last Name | Smith123@ |

### Steps

1. Populate all required fields with valid values.
2. Enter **Smith123@** into the Last Name field.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Last Name' can only contain letters and spaces."**

  is displayed.
- The user record is not created.

---

## TC-USR-019 — Verify Email format validation

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Format)

### Test Data

| Field | Value |
|------|------|
| Username | invalid_email_01 |
| Password | Password123 |
| Email | sample#sample.com |

### Steps

1. Populate all required fields with valid values.
2. Enter an invalid email address.
3. Click **Save**.

### Expected Result

- Validation message:

  **"The 'Email' field must be a valid email address."**

  is displayed.
- The user record is not created.

---

## TC-USR-020 — Verify "Save & Add Another" functionality

**Priority:** High

**Type:** Functional Testing

**Technique:** Positive Testing

### Preconditions

The username **save_add_01** does not already exist.

### Test Data

| Field | Value |
|------|------|
| Username | save_add_01 |
| Password | Password123 |
| First Name | Ihor |
| Last Name | Tovt |
| Company | Novum |
| Phone | (343)323-4543 |
| Email | save_add_01@test.com |

### Steps

1. Populate all required fields with valid values.
2. Click **Save & Add Another**.

### Expected Result

- The user is successfully created.
- A confirmation notification with the text **"Created"** is displayed.