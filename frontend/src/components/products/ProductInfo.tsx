import { Button } from "@/components/ui/button"

interface ProductInfoProps {
    name: string
    category: string
    price: number
    description: string
}

export function ProductInfo({
                                name,
                                category,
                                price,
                                description,
                            }: ProductInfoProps) {
    return (
        <div className="space-y-6">
            <div className="space-y-2">
                <p className="text-sm text-muted-foreground">
                    {category}
                </p>

                <h1 className="text-3xl font-bold tracking-tight">
                    {name}
                </h1>
            </div>

            <p className="text-2xl font-bold">
                ${price.toFixed(2)}
            </p>

            <p className="leading-7 text-muted-foreground">
                {description}
            </p>

            <div className="space-y-3">
                <p className="text-sm font-medium">
                    Cantidad
                </p>

                <div className="flex items-center gap-3">
                    <Button variant="outline" size="icon">
                        -
                    </Button>

                    <span className="w-8 text-center">
            1
          </span>

                    <Button variant="outline" size="icon">
                        +
                    </Button>
                </div>
            </div>

            <Button className="w-full sm:w-auto">
                Agregar al carrito
            </Button>
        </div>
    )
}