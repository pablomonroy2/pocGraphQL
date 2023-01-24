import Config

config :perf_analyzer,
  url: "http://_IP_:8080/graphqlpath",
  request: %{
    method: "POST",
    headers: [{"Content-Type", "application/json"}],
    body: "{\"query\":\"{ getBankAccounts{ userName currency id balance accountType }}\"}"
  },
  execution: %{
    steps: 20,
    increment: 50,
    duration: 1000,
    constant_load: false,
    dataset: :none,
    separator: ","
  },
  distributed: :none

config :logger,
  level: :warn
