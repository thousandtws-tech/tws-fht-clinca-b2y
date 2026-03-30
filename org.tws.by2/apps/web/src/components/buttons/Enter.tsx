import { Link } from "react-router-dom";

type Props = {
  to: string;
};

export function ButtonEnter({ to, children }: React.PropsWithChildren<Props>) {
  return (
    <Link to={to}>
        <li className="header-items hover:cursor-pointer inline-flex items-center justify-center gap-2 whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors hover:bg-accent h-10 px-4 py-2 text-blue-600 hover:text-blue-700">{children}</li>
    </Link>
  );
}