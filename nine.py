MOD = 10**9 + 7

def calculate_result(x):
    return (8 * pow(9, x-1, MOD)) % MOD

num_iterations = int(input())
for _ in range(num_iterations):
    x = int(input())
    print(str(calculate_result(x)))
