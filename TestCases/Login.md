# Login Test Cases

## Project Information

| Property | Value |
|----------|-------|
| **Application** | SmartBank LoanApp |
| **Module** | Login |
| **Document Type** | Manual Test Cases |
| **Author** | Ihor Tovt |
| **Version** | 1.0 |

---

## Scope

This document contains manual test cases for the **Login** module of the SmartBank LoanApp application.

The test suite covers:

- UI validation
- Positive scenarios
- Negative scenarios
- Equivalence Partitioning (EP)
- Authentication validation
- Case-sensitivity verification
- Session persistence ("Remember Me")

---

## Common Preconditions

- The SmartBank LoanApp Login page is open.
- Unless stated otherwise, a valid user account exists:
    - **Branch:** Halifax
    - **Username:** admin
    - **Password:** itovt0719

---

# Test Cases

---

## TC-LGN-001 — Verify Login page layout

**Priority:** Medium

**Type:** UI Testing

**Technique:** UI Validation

### Steps

1. Navigate to the Login page.
2. Observe all visible page elements.

### Expected Result

- The Login page is displayed successfully.
- The following input fields are available:
    - Branch Name
    - Username
    - Password
- The **Password** field masks entered characters.
- The **Remember Me** checkbox is displayed.
- The **Sign In** button is displayed and enabled.

---

## TC-LGN-002 — Verify successful login with valid credentials

**Priority:** Critical

**Type:** Functional Testing

**Technique:** Positive Testing

### Test Data

| Field | Value |
|------|------|
| Branch Name | Halifax |
| Username | admin |
| Password | itovt0719 |

### Steps

1. Enter valid credentials into all login fields.
2. Click **Sign In**.

### Expected Result

- The user is successfully authenticated.
- The Dashboard page is displayed.
- The page title matches the selected branch.
- The authenticated user session is created.

---

## TC-LGN-003 — Verify Branch Name is a required field

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Branch Name | *(empty)* |
| Username | admin |
| Password | itovt0719 |

### Steps

1. Leave the **Branch Name** field empty.
2. Enter valid Username and Password.
3. Click **Sign In**.

### Expected Result

- The browser displays the validation message:

  **"Please fill out this field."**

- Focus remains on the **Branch Name** field.
- Authentication is not performed.

---

## TC-LGN-004 — Verify Username is a required field

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Branch Name | Halifax |
| Username | *(empty)* |
| Password | itovt0719 |

### Steps

1. Enter a valid Branch Name.
2. Leave the **Username** field empty.
3. Enter a valid Password.
4. Click **Sign In**.

### Expected Result

- The browser displays the validation message:

  **"Please fill out this field."**

- Focus remains on the **Username** field.
- Authentication is not performed.


---

## TC-LGN-005 — Verify Password is a required field

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Test Data

| Field | Value |
|------|------|
| Branch Name | Halifax |
| Username | admin |
| Password | *(empty)* |

### Steps

1. Enter a valid Branch Name.
2. Enter a valid Username.
3. Leave the **Password** field empty.
4. Click **Sign In**.

### Expected Result

- The browser displays the validation message:

  **"Please fill out this field."**

- Focus remains on the **Password** field.
- Authentication is not performed.

---

## TC-LGN-006 — Verify validation when all required fields are empty

**Priority:** High

**Type:** Validation Testing

**Technique:** Equivalence Partitioning (Invalid Class)

### Steps

1. Leave all login fields empty.
2. Click **Sign In**.

### Expected Result

- The browser displays the validation message:

  **"Please fill out this field."**

  for the **Branch Name** field.

- Focus remains on the **Branch Name** field.
- Authentication is not performed.

> **Note:** HTML5 form validation validates the first required field only. Validation for the remaining fields is displayed only after the previous required fields are completed.

---

## TC-LGN-007 — Verify login fails with an invalid Branch Name

**Priority:** High

**Type:** Authentication Testing

**Technique:** Negative Testing

### Test Data

| Field | Value |
|------|------|
| Branch Name | Toronto |
| Username | admin |
| Password | itovt0719 |

### Steps

1. Enter an invalid Branch Name.
2. Enter a valid Username.
3. Enter a valid Password.
4. Click **Sign In**.

### Expected Result

- An authentication error message is displayed indicating that the specified branch does not exist.
- The user remains on the Login page.
- Authentication is not performed.

---

## TC-LGN-008 — Verify login fails with an invalid Username

**Priority:** High

**Type:** Authentication Testing

**Technique:** Negative Testing

### Test Data

| Field | Value |
|------|------|
| Branch Name | Halifax |
| Username | admin123 |
| Password | itovt0719 |

### Steps

1. Enter a valid Branch Name.
2. Enter an invalid Username.
3. Enter a valid Password.
4. Click **Sign In**.

### Expected Result

- An authentication error message:

  **"Invalid username or password."**

  is displayed.

- The user remains on the Login page.
- Authentication is not performed.

---

## TC-LGN-009 — Verify login fails with an invalid Password

**Priority:** High

**Type:** Authentication Testing

**Technique:** Negative Testing

### Test Data

| Field | Value |
|------|------|
| Branch Name | Halifax |
| Username | admin |
| Password | InvalidPassword1 |

### Steps

1. Enter a valid Branch Name.
2. Enter a valid Username.
3. Enter an invalid Password.
4. Click **Sign In**.

### Expected Result

- An authentication error message:

  **"Invalid username or password."**

  is displayed.

- The user remains on the Login page.
- Authentication is not performed.


---

## TC-LGN-010 — Verify Branch Name is case-insensitive

**Priority:** Medium

**Type:** Authentication Testing

**Technique:** Equivalence Partitioning (Case Sensitivity Verification)

### Test Data

| Field | Value |
|------|------|
| Branch Name | HALIFAX |
| Username | admin |
| Password | itovt0719 |

### Steps

1. Enter the Branch Name in uppercase.
2. Enter a valid Username.
3. Enter a valid Password.
4. Click **Sign In**.

### Expected Result

- The user is successfully authenticated.
- The Dashboard page is displayed.
- Authentication succeeds regardless of the letter case used for the Branch Name.

---

## TC-LGN-011 — Verify Username is case-insensitive

**Priority:** Medium

**Type:** Authentication Testing

**Technique:** Equivalence Partitioning (Case Sensitivity Verification)

### Test Data

| Field | Value |
|------|------|
| Branch Name | Halifax |
| Username | ADMIN |
| Password | itovt0719 |

### Steps

1. Enter a valid Branch Name.
2. Enter the Username in uppercase.
3. Enter a valid Password.
4. Click **Sign In**.

### Expected Result

- The user is successfully authenticated.
- The Dashboard page is displayed.
- Authentication succeeds regardless of the letter case used for the Username.

> **Note:** This behavior should be confirmed with business requirements, as some systems intentionally treat usernames as case-sensitive.

---

## TC-LGN-012 — Verify Password is case-sensitive

**Priority:** High

**Type:** Authentication Testing

**Technique:** Equivalence Partitioning (Case Sensitivity Verification)

### Test Data

| Field | Value |
|------|------|
| Branch Name | Halifax |
| Username | admin |
| Password | ITOVT0719 |

### Steps

1. Enter a valid Branch Name.
2. Enter a valid Username.
3. Enter the Password using different letter casing.
4. Click **Sign In**.

### Expected Result

- An authentication error message:

  **"Invalid username or password."**

  is displayed.

- The user remains on the Login page.
- Authentication is not performed.

---

## TC-LGN-013 — Verify "Remember Me" functionality

**Priority:** Medium

**Type:** Functional Testing

**Technique:** State Persistence Testing

### Test Data

| Field | Value |
|------|------|
| Branch Name | Halifax |
| Username | admin |
| Password | itovt0719 |

### Steps

1. Enter valid credentials.
2. Select the **Remember Me** checkbox.
3. Click **Sign In**.
4. Log out of the application.
5. Close the browser completely.
6. Open the browser again.
7. Navigate to the Login page.

### Expected Result

- The user is successfully authenticated during the initial login.
- After reopening the browser, the previously saved login credentials remain populated in the login form.
- The user can sign in again without re-entering the saved credentials.

---

## TC-LGN-014 — Verify successful logout

**Priority:** Medium

**Type:** Functional Testing

**Technique:** Positive Testing

### Preconditions

The user is successfully logged in.

### Steps

1. Click the user profile icon.
2. Click **Log out**.

### Expected Result

- The current user session is terminated.
- The Login page is displayed.
- The user can no longer access authenticated pages without signing in again.

---

## TC-LGN-015 — Verify Password field masks entered characters

**Priority:** Low

**Type:** UI Testing

**Technique:** UI Validation

### Steps

1. Place the cursor inside the **Password** field.
2. Enter any valid password.

### Expected Result

- Every entered character is masked.
- The actual password value is not visible while typing.

---