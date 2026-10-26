import {
    LayoutDashboard,
    Package,
    ShoppingCart,
    Tag,
    User,
    LogIn,
    ClipboardList,
} from "lucide-react"

import { NavLink } from "react-router-dom"

import {
    Sidebar,
    SidebarContent,
    SidebarGroup,
    SidebarGroupContent,
    SidebarGroupLabel,
    SidebarMenu,
    SidebarMenuButton,
    SidebarMenuItem,
} from "@/components/ui/sidebar"

const storeItems = [
    {
        title: "Inicio",
        icon: LayoutDashboard,
        path: "/",
    },
    {
        title: "Productos",
        icon: Package,
        path: "/productos",
    },
    {
        title: "Ofertas",
        icon: Tag,
        path: "/ofertas",
    },
    {
        title: "Carrito",
        icon: ShoppingCart,
        path: "/carrito",
    },
]

const accountItems = [
    {
        title: "Mi cuenta",
        icon: User,
        path: "/cuenta",
    },
    {
        title: "Mis pedidos",
        icon: ClipboardList,
        path: "/mis-pedidos",
    },
    {
        title: "Iniciar sesión",
        icon: LogIn,
        path: "/login",
    },
]

export function AppSidebar() {
    // @ts-ignore
    return (
        <Sidebar>
            <SidebarContent>

                {/* Tienda */}
                <SidebarGroup>
                    <SidebarGroupLabel>E-Commerce</SidebarGroupLabel>

                    <SidebarGroupContent>
                        <SidebarMenu>

                            {storeItems.map((item) => (
                                <SidebarMenuItem key={item.title}>
                                    <SidebarMenuButton>
                                        <NavLink
                                            to={item.path}
                                            className="flex w-full items-center gap-2"
                                        >
                                            <item.icon />
                                            <span>{item.title}</span>
                                        </NavLink>
                                    </SidebarMenuButton>
                                </SidebarMenuItem>
                            ))}

                        </SidebarMenu>
                    </SidebarGroupContent>
                </SidebarGroup>

                {/* Cuenta */}
                <SidebarGroup>
                    <SidebarGroupLabel>Cuenta</SidebarGroupLabel>

                    <SidebarGroupContent>
                        <SidebarMenu>

                            {accountItems.map((item) => (
                                <SidebarMenuItem key={item.title}>
                                    <SidebarMenuButton>
                                        <NavLink
                                            to={item.path}
                                            className="flex w-full items-center gap-2"
                                        >
                                            <item.icon />
                                            <span>{item.title}</span>
                                        </NavLink>
                                    </SidebarMenuButton>
                                </SidebarMenuItem>
                            ))}

                        </SidebarMenu>
                    </SidebarGroupContent>
                </SidebarGroup>

            </SidebarContent>
        </Sidebar>
    )
}