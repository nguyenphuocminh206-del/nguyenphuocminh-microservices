# Lab 02 - Microservices quản lý bán hàng

Repo gồm hai Spring Boot service độc lập, mỗi service dùng database riêng theo yêu cầu Lab 02.

| Service | Port | Database | Bảng |
| --- | ---: | --- | --- |
| Product Service | 8081 | MySQL `product_db` | categories, brands, products, product_images |
| Order Service | 8082 | SQL Server `order_db` | orders, order_items, carts, cart_items |

## Chuẩn bị database

Tạo trước hai database rỗng: `product_db` trên MySQL và `order_db` trên SQL Server. Hibernate tạo/cập nhật bảng khi service khởi động. Mỗi service chỉ kết nối database của chính nó.

Đặt biến môi trường kết nối trước khi chạy:

- `MYSQL_PASSWORD`: mật khẩu MySQL (username mặc định `root`).
- `SQLSERVER_PASSWORD`: mật khẩu SQL Server (username mặc định `sa`).
- Có thể đặt `SQLSERVER_URL` hoặc `SQLSERVER_USERNAME` để thay cấu hình mặc định.

## Chạy

Từ thư mục gốc repo, chạy từng lệnh trong cửa sổ terminal riêng:

```powershell
cd backend/product-service
.\mvnw.cmd spring-boot:run
```

```powershell
cd backend/order-service
.\mvnw.cmd spring-boot:run
```

## REST API CRUD

Mỗi đường dẫn dưới đây hỗ trợ `GET` danh sách, `GET /{id}`, `POST`, `PUT /{id}` và `DELETE /{id}`.

**Product Service** (`http://localhost:8081`): `/api/categories`, `/api/brands`, `/api/products`, `/api/product-images`.

**Order Service** (`http://localhost:8082`): `/api/orders`, `/api/order-items`, `/api/carts`, `/api/cart-items`.

Các quan hệ thuộc cùng database được ánh xạ bằng JPA. Khi tạo/cập nhật sản phẩm, ảnh sản phẩm, chi tiết đơn hoặc chi tiết giỏ hàng, truyền quan hệ dạng `{ "category": { "id": 1 } }`, `{ "product": { "id": 1 } }`, `{ "order": { "id": 1 } }` hoặc `{ "cart": { "id": 1 } }` tương ứng.
