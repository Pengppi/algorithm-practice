<p>给你一个大小为 <code>m x n</code> 的二进制矩阵 <code>mat</code> ，请你找出包含最多 <strong>1</strong> 的行的下标（从 <strong>0</strong> 开始）以及这一行中 <strong>1</strong> 的数目。</p>

<p>如果有多行包含最多的 1 ，只需要选择 <strong>行下标最小</strong> 的那一行。</p>

<p>返回一个由行下标和该行中 1 的数量组成的数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>mat = [[0,1],[1,0]]
<strong>输出：</strong>[0,1]
<strong>解释：</strong>两行中 1 的数量相同。所以返回下标最小的行，下标为 0 。该行 1 的数量为 1 。所以，答案为 [0,1] 。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>mat = [[0,0,0],[0,1,1]]
<strong>输出：</strong>[1,2]
<strong>解释：</strong>下标为 1 的行中 1 的数量最多<span><code>。</code></span>该行 1 的数量<span><code>为 2 。所以，答案为</code></span> [1,2] 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>mat = [[0,0],[1,1],[0,0]]
<strong>输出：</strong>[1,2]
<strong>解释：</strong>下标为 1 的行中 1 的数量最多。该行 1 的数量<span><code>为 2 。所以，答案为</code></span> [1,2] 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == mat.length</code>&nbsp;</li> 
 <li><code>n == mat[i].length</code>&nbsp;</li> 
 <li><code>1 &lt;= m, n &lt;= 100</code>&nbsp;</li> 
 <li><code>mat[i][j]</code> 为 <code>0</code> 或 <code>1</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>矩阵</li></div></div><br><div><li>👍 22</li><li>👎 0</li></div>