import { Input, Avatar, Dropdown, Space } from "antd";
import { UserOutlined, LogoutOutlined } from "@ant-design/icons";

export function HeaderBar() {
  const items = [
    {
      key: "profile",
      label: "Perfil",
      icon: <UserOutlined />,
    },
    {
      key: "logout",
      label: "Sair",
      icon: <LogoutOutlined />,
    },
  ];

  return (
    <div className="h-16 bg-white flex items-center justify-between px-10 border-b">

      <Input.Search
        placeholder="Buscar leads, contatos..."
        style={{ maxWidth: 300 }}
        onSearch={(value) => console.log(value)}
      />


      <Dropdown menu={{ items }}>
        <Space className="cursor-pointer">
          <Avatar icon={<UserOutlined />} />
          <span>Admin</span>
        </Space>
      </Dropdown>

    </div>
  );
}