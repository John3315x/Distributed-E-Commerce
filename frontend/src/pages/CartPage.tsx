import { Button } from "@/components/ui/button"
import {
    Card,
    CardContent,
} from "@/components/ui/card"

const cartItems = [
    {
        id: 1,
        name: "Laptop Pro",
        price: 899.99,
        quantity: 1,
        image: "https://images.unsplash.com/photo-1496181133206-80ce9b88a853",
    },
    {
        id: 2,
        name: "Teclado Mecánico",
        price: 79.99,
        quantity: 2,
        image: "https://images.unsplash.com/photo-1587829741301-dc798b83add3",
    },
]

export default function CartPage() {
    return (
        <div className="mx-auto w-full max-w-32xl space-y-8 px-6 py-8">

            {/* Encabezado */}
            <div className="space-y-2">
                <h1 className="text-3xl font-bold tracking-tight">
                    Carrito
                </h1>

                <p className="text-muted-foreground">
                    Revisa los productos que has agregado a tu carrito.
                </p>
            </div>

            {/* Contenido */}
            <div className="grid gap-8 lg:grid-cols-3">

                {/* Productos */}
                <div className="space-y-4 lg:col-span-2">
                    {cartItems.map((item) => (
                        <Card key={item.id}>
                            <CardContent className="flex gap-4 p-4">

                                {/* Imagen */}
                                <div className="h-24 w-24 shrink-0 overflow-hidden rounded-md bg-muted">
                                    <img
                                        src={item.image}
                                        alt={item.name}
                                        className="h-full w-full object-cover"
                                    />
                                </div>

                                {/* Información */}
                                <div className="flex flex-1 flex-col justify-between gap-4 sm:flex-row">

                                    <div className="space-y-1">
                                        <h2 className="font-semibold">
                                            {item.name}
                                        </h2>

                                        <p className="text-sm text-muted-foreground">
                                            ${item.price.toFixed(2)}
                                        </p>
                                    </div>

                                    {/* Cantidad */}
                                    <div className="flex items-center gap-3">
                                        <Button variant="outline" size="icon">
                                            -
                                        </Button>

                                        <span className="w-6 text-center">
                      {item.quantity}
                    </span>

                                        <Button variant="outline" size="icon">
                                            +
                                        </Button>
                                    </div>

                                </div>

                            </CardContent>
                        </Card>
                    ))}
                </div>

                {/* Resumen */}
                <Card className="h-fit">
                    <CardContent className="space-y-6 p-6">

                        <h2 className="text-xl font-semibold">
                            Resumen del pedido
                        </h2>

                        <div className="space-y-3 text-sm">
                            <div className="flex justify-between">
                <span className="text-muted-foreground">
                  Subtotal
                </span>

                                <span>
                  $1,059.97
                </span>
                            </div>

                            <div className="flex justify-between">
                <span className="text-muted-foreground">
                  Envío
                </span>

                                <span>
                  Gratis
                </span>
                            </div>
                        </div>

                        <div className="border-t pt-4">
                            <div className="flex justify-between text-lg font-bold">
                                <span>Total</span>
                                <span>$1,059.97</span>
                            </div>
                        </div>

                        <Button className="w-full">
                            Continuar compra
                        </Button>

                    </CardContent>
                </Card>

            </div>
        </div>
    )
}