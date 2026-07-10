# BUG-USR-002 — Password field allows entering unlimited characters

## Bug Information

| Property | Value |
|----------|-------|
| **Bug ID** | BUG-USR-002 |
| **Module** | User Management |
| **Severity** | Medium |
| **Priority** | Medium |
| **Status** | Open |
| **Reported By** | Ihor Tovt |
| **Environment** | SmartBank LoanApp (QA Environment) |

---

# Summary

The **Password** field does not enforce the maximum allowed input length and accepts an unlimited number of characters.

---

# Preconditions

- User is logged in as **Administrator**.
- Branch: **Halifax**.
- The **Add User** page is open.

---

# Steps to Reproduce

1. Navigate to **Users**.
2. Click **Add User**.
3. Place the cursor inside the **Password** field.
4. Enter more than **32 characters**.
5. Observe the field behavior.

---

# Actual Result

The Password field accepts an unlimited number of characters without restricting the input length.

---

# Expected Result

The Password field should accept no more than **32 characters**.

Any additional characters entered beyond the maximum allowed length should be ignored.

---

# Business Impact

- The application allows input outside the defined business rules.
- Missing client-side validation may lead to inconsistent user experience.
- Excessively long input may increase the risk of validation or processing issues on the server side.

---

# Root Cause (Suspected)

The Password field does not enforce a client-side maximum input length (`maxlength`) or an equivalent validation mechanism.

---

# Attachments

- Screenshot of the Password field accepting more than 32 characters.
- Azure DevOps Bug #15

---