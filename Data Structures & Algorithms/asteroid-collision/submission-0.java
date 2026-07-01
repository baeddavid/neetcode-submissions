class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /*
        positive go right, negative go left.
        compare absolute values; larger survives, keep its sign.
        stack holds the "collision zone": positives on top.
        a surviving negative has nothing left to hit, so it joins the stack too
        (it lands below the positive run, which is the correct final order).
        */
        Deque<Integer> stack = new ArrayDeque<>();

        int astPointer = 0;
        while (astPointer < asteroids.length) {
            if (asteroids[astPointer] < 0) {
                // only a positive on top can collide with an incoming left-mover
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[astPointer]);   // survives — nothing to hit
                    astPointer++;
                } else if (Math.abs(asteroids[astPointer]) == stack.peek()) {
                    stack.pop();                         // equal → both explode
                    astPointer++;
                } else if (Math.abs(asteroids[astPointer]) > stack.peek()) {
                    stack.pop();                         // top smaller → it explodes, keep checking
                } else {
                    astPointer++;                        // top bigger → incoming explodes
                }
            } else {
                stack.push(asteroids[astPointer]);
                astPointer++;
            }
        }

        // drain bottom→top into the result in original left-to-right order
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }
}