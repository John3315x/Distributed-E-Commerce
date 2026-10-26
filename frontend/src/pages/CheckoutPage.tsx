import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import {
    Card,
    CardContent,
    CardHeader,
} from "@/components/ui/card"

export default function CheckoutPage() {
    return (
        <div className="mx-auto w-full max-w-32xl space-y-8 px-6 py-8">

            {/* Encabezado */}
            <div className="space-y-2">
                <h1 className="text-3xl font-bold tracking-tight">
                    Finalizar compra
                </h1>

                <p className="text-muted-foreground">
                    Completa tus datos para realizar el pedido.
                </p>
            </div>

            {/* Contenido */}
            <div className="grid gap-8 lg:grid-cols-3">

                {/* Información del cliente */}
                <div className="space-y-6 lg:col-span-2">

                    {/* Dirección */}
                    <Card>
                        <CardHeader>
                            <h2 className="text-xl font-semibold">
                                Información de envío
                            </h2>
                        </CardHeader>

                        <CardContent className="grid gap-5 sm:grid-cols-2">

                            <div className="space-y-2">
                                <label
                                    htmlFor="name"
                                    className="text-sm font-medium"
                                >
                                    Nombre completo
                                </label>

                                <Input
                                    id="name"
                                    placeholder="Tu nombre completo"
                                />
                            </div>

                            <div className="space-y-2">
                                <label
                                    htmlFor="phone"
                                    className="text-sm font-medium"
                                >
                                    Teléfono
                                </label>

                                <Input
                                    id="phone"
                                    type="tel"
                                    placeholder="8888-8888"
                                />
                            </div>

                            <div className="space-y-2 sm:col-span-2">
                                <label
                                    htmlFor="address"
                                    className="text-sm font-medium"
                                >
                                    Dirección
                                </label>

                                <Input
                                    id="address"
                                    placeholder="Dirección de envío"
                                />
                            </div>

                            <div className="space-y-2">
                                <label
                                    htmlFor="city"
                                    className="text-sm font-medium"
                                >
                                    Ciudad
                                </label>

                                <Input
                                    id="city"
                                    placeholder="Ciudad"
                                />
                            </div>

                            <div className="space-y-2">
                                <label
                                    htmlFor="postalCode"
                                    className="text-sm font-medium"
                                >
                                    Código postal
                                </label>

                                <Input
                                    id="postalCode"
                                    placeholder="Código postal"
                                />
                            </div>

                        </CardContent>
                    </Card>

                    {/* Método de pago */}
                    <Card>
                        <CardHeader>
                            <h2 className="text-xl font-semibold">
                                Método de pago
                            </h2>
                        </CardHeader>

                        <CardContent className="space-y-4">

                            <div className="rounded-lg border p-4">
                                <p className="font-medium">
                                    Tarjeta de crédito o débito
                                </p>

                                <p className="mt-1 text-sm text-muted-foreground">
                                    El pago será procesado de forma segura.
                                </p>
                            </div>

                            <Input
                                placeholder="Número de tarjeta"
                            />

                            <div className="grid gap-4 sm:grid-cols-2">
                                <Input
                                    placeholder="MM / AA"
                                />

                                <Input
                                    placeholder="CVV"
                                />
                            </div>

                        </CardContent>
                    </Card>

                </div>

                {/* Resumen */}
                <Card className="h-fit">
                    <CardHeader>
                        <h2 className="text-xl font-semibold">
                            Resumen del pedido
                        </h2>
                    </CardHeader>

                    <CardContent className="space-y-6">

                        <div className="space-y-4 text-sm">

                            <div className="flex justify-between">
                <span>
                  Laptop Pro × 1
                </span>

                                <span>
                  $899.99
                </span>
                            </div>

                            <div className="flex justify-between">
                <span>
                  Teclado Mecánico × 2
                </span>

                                <span>
                  $159.98
                </span>
                            </div>

                        </div>

                        <div className="border-t pt-4">
                            <div className="flex justify-between text-lg font-bold">
                <span>
                  Total
                </span>

                                <span>
                  $1,059.97
                </span>
                            </div>
                        </div>

                        <Button className="w-full">
                            Confirmar pedido
                        </Button>

                    </CardContent>
                </Card>

            </div>
        </div>
    )
}