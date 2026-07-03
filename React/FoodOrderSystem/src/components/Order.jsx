import React, { useEffect, useState } from "react";
import { Card, Button } from "react-bootstrap";

const Order = () => {
  const [orders, setOrders] = useState([]);
  const email = "test@gmail.com";

  const fetchOrders = () => {
    fetch(`http://localhost:8080/order/${email}`)
      .then((res) => res.json())
      .then((data) => setOrders(data))
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    fetchOrders();
  }, []);

  // ✅ Cancel Order function
  const cancelOrder = (id) => {
    fetch(`http://localhost:8080/order/cancel/${id}`, {
      method: "PUT",
    })
      .then((res) => res.json())
      .then(() => {
        alert("Order Cancelled ❌");
        fetchOrders(); // refresh UI
      })
      .catch((err) => console.error(err));
  };

  return (
    <div className="container mt-4">
      <h2 className="text-center fw-bold mb-4">Your Orders 📦</h2>

      {orders.length === 0 ? (
        <h4 className="text-center text-muted">No Orders Found</h4>
      ) : (
        <div className="row">
          {orders.map((o) => (
            <div className="col-md-6 mb-4" key={o.id}>
              <Card className="shadow border-0 rounded-4 p-3">
                <h5 className="fw-bold">Order #{o.id}</h5>

                <p className="mb-1">
                  Total: <span className="fw-bold">{o.totalAmount} ₹</span>
                </p>

                <p
                  className={`fw-semibold ${
                    o.status === "CANCELLED"
                      ? "text-danger"
                      : "text-success"
                  }`}
                >
                  {o.status}
                </p>

                <small className="text-muted">{o.orderTime}</small>

                <hr />

                <h6>Items:</h6>

                {o.items &&
                  o.items.map((item) => (
                    <div
                      key={item.id}
                      className="d-flex align-items-center gap-3 mb-2"
                    >
                      <img
                        src={item.imageUrl || "https://via.placeholder.com/80"}
                        alt={item.foodName}
                        style={{
                          width: "70px",
                          height: "70px",
                          objectFit: "cover",
                        }}
                        className="rounded"
                      />

                      <div>
                        <p className="mb-0 fw-semibold">{item.foodName}</p>
                        <small>Qty: {item.quantity}</small>
                      </div>
                    </div>
                  ))}

                {/* ✅ Cancel Button */}
                {o.status !== "CANCELLED" && (
                  <div className="text-end mt-2">
                    <Button
                      variant="outline-danger"
                      size="sm"
                      onClick={() => cancelOrder(o.id)}
                    >
                      Cancel Order
                    </Button>
                  </div>
                )}
              </Card>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Order;