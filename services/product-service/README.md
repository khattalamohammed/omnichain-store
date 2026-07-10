# 📦 Product Service

The **Product Service** serves as a read-only catalog repository within the Omnichain ecosystem. Its primary architectural responsibility is to expose standardized product metadata and pricing to both the client and downstream services via strict API contracts.

---

## 🛰️ API Contract
### Get Product Details
Allows the client or the `Order Service` (via Feign) to retrieve item specifications and the current baseline price.

* **URL:** `/api/v1/products/{sku}`
* **Method:** `GET`
* **URL Params:** `sku=[string]` (e.g., `LAPTOP-01`)

#### 🟩 Success Response (`200 OK`)
```json
{
  "sku": "LAPTOP-01",
  "name": "Omnichain Pro Book 15",
  "description": "High-performance laptop for distributed systems engineering.",
  "price": 1299.99
}
```
#### 🟥 Error Response (404 NOT FOUND)
```json
{
  "timestamp": "2026-05-16T15:00:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Product with SKU 'INVALID-SKU' does not exist.",
  "path": "/api/v1/products/INVALID-SKU"
}
```