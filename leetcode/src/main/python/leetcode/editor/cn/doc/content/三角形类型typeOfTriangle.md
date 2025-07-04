<p>给你一个下标从 <strong>0</strong>&nbsp;开始长度为 <code>3</code>&nbsp;的整数数组&nbsp;<code>nums</code>&nbsp;，需要用它们来构造三角形。</p>

<ul> 
 <li>如果一个三角形的所有边长度相等，那么这个三角形称为&nbsp;<strong>equilateral</strong>&nbsp;。</li> 
 <li>如果一个三角形恰好有两条边长度相等，那么这个三角形称为&nbsp;<strong>isosceles</strong>&nbsp;。</li> 
 <li>如果一个三角形三条边的长度互不相同，那么这个三角形称为&nbsp;<strong>scalene</strong>&nbsp;。</li> 
</ul>

<p>如果这个数组无法构成一个三角形，请你返回字符串&nbsp;<code>"none"</code>&nbsp;，否则返回一个字符串表示这个三角形的类型。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [3,3,3]
<b>输出：</b>"equilateral"
<b>解释：</b>由于三条边长度相等，所以可以构成一个等边三角形，返回 "equilateral" 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [3,4,5]
<b>输出：</b>"scalene"
<b>解释：</b>
nums[0] + nums[1] = 3 + 4 = 7 ，大于 nums[2] = 5 <span style="text-wrap: wrap;">。</span>
nums[0] + nums[2] = 3 + 5 = 8 ，大于 nums[1] = 4 。
nums[1] + nums[2] = 4 + 5 = 9 ，大于 nums[0] = 3 。
由于任意两边之和都大于第三边，所以可以构成一个三角形，因为三条边的长度互不相等，所以返回 "scalene"。
</pre>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>nums.length == 3</code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 100</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>排序</li></div></div><br><div><li>👍 6</li><li>👎 0</li></div>