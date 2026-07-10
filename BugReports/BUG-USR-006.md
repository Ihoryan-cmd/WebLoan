# BUG-LGN-001 — Application logo is missing on the Login page

## Bug Information

| Property | Value |
|----------|-------|
| **Bug ID** | BUG-LGN-001 |
| **Module** | Login |
| **Severity** | Low |
| **Priority** | Low |
| **Status** | Open |
| **Reported By** | Ihor Tovt |
| **Environment** | SmartBank LoanApp (QA Environment) |

---

# Summary

The application logo is not displayed on the left side of the Login page. Instead, only the blue background is visible.

---

# Preconditions

- The SmartBank LoanApp Login page is accessible.
- The user has not signed in.

---

# Steps to Reproduce

1. Navigate to the SmartBank LoanApp Login page.
2. Observe the left side of the page.

---

# Actual Result

The application logo is not displayed.

Only the blue background is visible.

---

# Expected Result

The application logo should be displayed on the left side of the Login page according to the application design.

---

# Business Impact

- The Login page does not match the expected UI design.
- The application's branding is missing.
- May reduce user confidence in the application's quality and professionalism.

---

# Root Cause (Suspected)

The logo image may be missing, the asset path may be incorrect, or the image is not being rendered by the frontend.

---

# Attachments

- Screenshot showing the missing application logo.
- Azure DevOps Bug #6

---