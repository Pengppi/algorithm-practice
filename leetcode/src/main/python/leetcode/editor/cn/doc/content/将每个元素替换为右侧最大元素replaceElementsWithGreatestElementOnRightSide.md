<p>给你一个数组&nbsp;<code>arr</code>&nbsp;，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用&nbsp;<code>-1</code> 替换。</p>

<p>完成所有替换操作后，请你返回这个数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [17,18,5,4,6,1]
<strong>输出：</strong>[18,6,6,6,1,-1]
<strong>解释：</strong>
- 下标 0 的元素 --&gt; 右侧最大元素是下标 1 的元素 (18)
- 下标 1 的元素 --&gt; 右侧最大元素是下标 4 的元素 (6)
- 下标 2 的元素 --&gt; 右侧最大元素是下标 4 的元素 (6)
- 下标 3 的元素 --&gt; 右侧最大元素是下标 4 的元素 (6)
- 下标 4 的元素 --&gt; 右侧最大元素是下标 5 的元素 (1)
- 下标 5 的元素 --&gt; 右侧没有其他元素，替换为 -1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [400]
<strong>输出：</strong>[-1]
<strong>解释：</strong>下标<strong> </strong>0 的元素右侧没有其他元素。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= arr.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= arr[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li></div></div><br><div><li>👍 115</li><li>👎 0</li></div>