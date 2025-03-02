import grpc
import mysql.connector
import order_pb2
import order_pb2_grpc
from concurrent import futures

class OrderService(order_pb2_grpc.OrderServiceServicer):
    def CalculateTotal(self, request, context):
        conn = mysql.connector.connect(host="localhost", user="root", password="yourpassword", database="ecommerce")
        cursor = conn.cursor()
        cursor.execute("SELECT price FROM products WHERE product_id = %s", (request.product_id,))
        row = cursor.fetchone()
        cursor.close()
        conn.close()
        if row:
            return order_pb2.OrderResponse(total_price=row[0] * request.quantity)
        return order_pb2.OrderResponse(total_price=0)

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    order_pb2_grpc.add_OrderServiceServicer_to_server(OrderService(), server)
    server.add_insecure_port("[::]:50051")
    server.start()
    server.wait_for_termination()

if __name__ == "__main__":
    serve()
