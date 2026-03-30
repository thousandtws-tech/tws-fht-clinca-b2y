import { Link } from "react-router-dom";

type Props = {
  to: string;
};

export function ButtonRegister({ to, children }: React.PropsWithChildren<Props>) {
  return (
    <Link to={to}>
        <li className="header-items hover:cursor-pointer inline-flex items-center justify-center gap-2 whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 h-10 py-2 bg-blue-600 hover:bg-blue-700 text-white px-6">{children}</li>
    </Link>
  );
}

