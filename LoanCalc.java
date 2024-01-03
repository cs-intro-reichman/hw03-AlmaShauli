/**
 * Computes the periodical payment necessary to re-pay a given loan.
 */
public class LoanCalc {

	static double epsilon = 0.001; // The computation tolerance (estimation error)
	static int iterationCounter; // Monitors the efficiency of the calculation

	/**
	 * Gets the loan data and computes the periodical payment.
	 * Expects to get three command-line arguments: sum of the loan (double),
	 * interest rate (double, as a percentage), and number of payments (int).
	 */
	public static void main(String[] args) {
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}

	/**
	 * Uses a sequential search method ("brute force") to compute an approximation
	 * of the periodical payment that will bring the ending balance of a loan close
	 * to 0.
	 * Given: the sum of the loan, the periodical interest rate (as a percentage),
	 * the number of periods (n), and epsilon, a tolerance level.
	 */
	// Side effect: modifies the class variable iterationCounter.
	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {

		// Determines the initial periodical payment
		double g = loan / n;

		// Reset the iteration counter
		iterationCounter = 0;

		while ((endBalance(loan, rate, n, g) >= epsilon) && (g <= loan)) {

			// increases g by epsilon
			g += epsilon;

			// Increases the interaction by 1
			iterationCounter++;
		}
		return g;
	}

	/**
	 * Uses bisection search to compute an approximation of the periodical payment
	 * that will bring the ending balance of a loan close to 0.
	 * Given: the sum of theloan, the periodical interest rate (as a percentage),
	 * the number of periods (n), and epsilon, a tolerance level.
	 */
	// Side effect: modifies the class variable iterationCounter.
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {

		// Determines low and high such that f(low)>0 and f(high)<0
		double low = loan / n, high = loan;

		// Determines the mid-value (g)
		double g = (low + high) / 2;

		// Reset the iteration counter
		iterationCounter = 0;

		while ((high - low) > epsilon) {

			// Sets L and H for the next iteration
			if (endBalance(loan, rate, n, g) * endBalance(loan, rate, n, low) > 0) {
				low = g;
			} else {
				high = g;
			}

			// Computes the mid-value (g) to the next iteration
			g = (low + high) / 2;

			// Increases the iteration by 1
			iterationCounter++;
		}
		return g;
	}

	/**
	 * Computes the ending balance of a loan, given the sum of the loan, the
	 * periodical
	 * interest rate (as a percentage), the number of periods (n), and the
	 * periodical payment.
	 */
	private static double endBalance(double loan, double rate, int n, double payment) {

		// Determines the final balance of the loan
		double endingBalance = loan;

		// Converts the interest rate from a percentage to a decimal number
		double decimalRate = (rate / 100) + 1;

		// Reduces the periodic payment from the loan ending balance and adds the
		// periodic interest for each period
		for (int i = 1; i <= n; i++) {
			endingBalance = (endingBalance - payment) * decimalRate;
		}

		return endingBalance;
	}
}