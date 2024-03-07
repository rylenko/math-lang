# Math-Lang

Simple language with math operations.

# Usage

Prompt:

```
$ make run
> PUSH 19
> PUSH 30
> +
> PRINT
49.0
> SQRT
> PRINT
7.0
```

With file:

```
$ make run ARGS="<path>"
```

# Todo

- Abstract `ValidatedCommand` with args count and stack size validation.
