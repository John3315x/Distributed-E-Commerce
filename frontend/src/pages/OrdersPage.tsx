import { Button } from "@/components/ui/button"
import {
    Card,
    CardContent,
} from "@/components/ui/card"

const orders = [
    {
        id: "#ORD-001",
        date: "2 de septiembre de 2026",
        status: "Entregado",
        total: 979.98,
        products: [
            {
                name: "Laptop Pro",
                quantity: 1,
            },
            {
                name: "Teclado Mecánico",
                quantity: 1,
            },
        ],
    },
    {
        id: "#ORD-002",
        date: "28 de agosto de 2026",
        status: "En camino",
        total: 299.99,
        products: [
            {
                name: 'Monitor 27"',
                quantity: 1,
            },
        ],
    },
    {
        id: "#ORD-003",
        date: "15 de agosto de 2026",
        status: "Procesando",
        total: 169.98,
        products: [
            {
                name: "Mouse Inalámbrico",
                quantity: 1,
            },
            {
                name: "Audífonos",
                quantity: 1,
            },
        ],
    },
]

export default function OrdersPage() {
    return (
        <div className="mx-auto w-full max-w-32xl space-y-8 px-6 py-8">

            {/* Encabezado */}
            <div className="space-y-2">
                <h1 className="text-3xl font-bold tracking-tight">
                    Mis pedidos
                </h1>

                <p className="text-muted-foreground">
                    Consulta el estado y los detalles de tus pedidos.
                </p>
            </div>

            {/* Pedidos */}
            <div className="space-y-4">
                {orders.map((order) => (
                    <Card key={order.id}>
                        <CardContent className="p-6">

                            {/* Cabecera del pedido */}
                            <div className="flex flex-col justify-between gap-4 border-b pb-4 sm:flex-row sm:items-center">

                                <div className="space-y-1">
                                    <h2 className="font-semibold">
                                        Pedido {order.id}
                                    </h2>

                                    <p className="text-sm text-muted-foreground">
                                        {order.date}
                                    </p>
                                </div>

                                <div className="flex items-center gap-4">
                  <span className="rounded-full border px-3 py-1 text-sm">
                    {order.status}
                  </span>

                                    <span className="font-semibold">
                    ${order.total.toFixed(2)}
                  </span>
                                </div>

                            </div>

                            {/* Productos */}
                            <div className="space-y-3 py-4">
                                {order.products.map((product) => (
                                    <div
                                        key={product.name}
                                        className="flex justify-between text-sm"
                                    >
                    <span>
                      {product.name}
                    </span>

                                        <span className="text-muted-foreground">
                      × {product.quantity}
                    </span>
                                    </div>
                                ))}
                            </div>

                            {/* Acción */}
                            <div className="border-t pt-4">
                                <Button variant="outline">
                                    Ver detalles
                                </Button>
                            </div>

                        </CardContent>
                    </Card>
                ))}
            </div>

        </div>
    )
}