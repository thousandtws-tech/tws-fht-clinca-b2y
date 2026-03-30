export function Login() {
  return (
    <section>
      <div className="flex min-h-screen items-center justify-center bg-gray-100 p-4">
        <div className="rounded-lg border bg-card text-card-foreground w-full max-w-md shadow-lg">
          <div className="flex flex-col sapace-y-1.5 p-6 items-center text-center">
            <a href="/"> <img src="svgs/logo-fht.svg"/> </a>

            <div className="tracking-tight text-2xl font-bold pt-4">
              Entrar na Plataforma
            </div>
            <div className="text-sm text-muted-foreground">
              Use seu email e senha para continuar.
            </div>
          </div>
          <div className="p-6 pt-0">
            <form className="space-y-4">
              <div className="space-y-1.5">
                <label className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-gray-700">
                  Email
                </label>
                <input
                  className="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-base ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 md:text-sm"
                  id="email-login"
                  placeholder="seu.email@exemplo.com"
                  required
                  type="email"
                  value=""
                ></input>
              </div>
              <div className="space-y-1.5">
                <div className="flex items-center justify-between">
                  <label className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-gray-700">
                    Senha
                  </label>
                  <a
                    className="text-xs text-blue-600 hover:text-blue-500 hover:underline"
                    href="/reset-password"
                  >
                    Esqueceu a senha?
                  </a>
                </div>
                <input
                  className="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-base ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 md:text-sm"
                  id="password-login"
                  placeholder="********"
                  required
                  type="password"
                  value=""
                ></input>
              </div>
              <button
                className="inline-flex items-center justify-center gap-2 whitespace-nowrap rounded-md text-sm ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 [&amp;_svg]:pointer-events-none [&amp;_svg]:size-4 [&amp;_svg]:shrink-0 h-10 px-4 w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-3"
                type="submit"
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  className="lucide lucide-log-in mr-2 h-5 w-5"
                >
                  <path d="M15 3h4a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-4"></path>
                  <polyline points="10 17 15 12 10 7"></polyline>
                  <line x1="15" x2="3" y1="12" y2="12"></line>
                </svg>
                Entrar
              </button>
            </form>
          </div>
          <div className="p-6 flex flex-col items-center justify-center pt-4 border-t">
            <p className="text-xs text-gray-600">
              Não tem uma conta?{' '}
              <a className="font-medium text-blue-600 hover:text-blue-500 hover:underline" href="/register">
                Crie seu cadastro
              </a>
            </p>
          </div>
        </div>
      </div>
    </section>
  );
}
