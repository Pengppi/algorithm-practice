给你一个由 <strong>无重复</strong> 正整数组成的集合 <code>nums</code> ，请你找出并返回其中最大的整除子集 <code>answer</code> ，子集中每一元素对 <code>(answer[i], answer[j])</code> 都应当满足：

<ul> 
 <li><code>answer[i] % answer[j] == 0</code> ，或</li> 
 <li><code>answer[j] % answer[i] == 0</code></li> 
</ul>

<p>如果存在多个有效解子集，返回其中任何一个均可。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[1,2]
<strong>解释：</strong>[1,3] 也会被视为正确答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,4,8]
<strong>输出：</strong>[1,2,4,8]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 1000</code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 2 * 10<sup>9</sup></code></li> 
 <li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>动态规划</li><li>排序</li></div></div><br><div><li>👍 595</li><li>👎 0</li></div>