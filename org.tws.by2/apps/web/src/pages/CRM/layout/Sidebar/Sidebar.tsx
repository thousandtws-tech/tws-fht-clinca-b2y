import { Menu } from "antd";

import {
  DashboardOutlined,
  UserOutlined
} from "@ant-design/icons";

import { Link, useNavigate } from "react-router-dom";

import Logo from "../../../../assets/svgs/logo-fht.svg"

export function Sidebar() {
  const navigate = useNavigate();

  return (
    <div className=" h-full bg-white border-r">
      <div className="p-5">
        <Link to={"/painel/dashboard"}><img src={Logo} className="w-50" alt="" /></Link>
      </div>

      <Menu
      
        mode="inline"
        onClick={(e) => navigate(e.key)}
        items={[
          { key: "/painel/dashboard", icon: <DashboardOutlined />, label: "Dashboard" },
          { key: "/painel/leads", icon: <UserOutlined />, label: "Leads" },
        ]}
      />
    </div>
  );
}