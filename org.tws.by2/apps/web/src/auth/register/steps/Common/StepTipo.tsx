import { Form } from "antd";

export function StepTipo({ next }: { next: () => void }) {
  const form = Form.useFormInstance();

  function select(tipo: string) {
    form.setFieldsValue({ tipo });
    next(); 
  }

  return (
    <div>
      <button onClick={() => select("empresa")}>
        Empresa
      </button>

      <button onClick={() => select("medico")}>
        Médico
      </button>
    </div>
  );
}